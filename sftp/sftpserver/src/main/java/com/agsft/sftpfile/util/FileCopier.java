package com.agsft.sftpfile.util;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.ChannelSftp.LsEntry;

/**
 * @author Balasaheb Pawar
 * @date 22 Sep 2018
 */
@Component
public class FileCopier {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileCopier.class);

	@Value(value = "${sftp.remote.server.port}")
	private int remotePort;

	@Value(value = "${sftp.remote.server.host}")
	private String remoteHost;

	@Value(value = "${sftp.remote.server.username}")
	private String username;

	@Value(value = "${sftp.remote.server.keyFileName}")
	private String sshKeyFileName;

	@Value(value = "${sftp.remote.server.passphrase}")
	private String passphrase;

	@Value(value = "${sftp.remote.server.directory}")
	private String remoteDirectory;

	@Value(value = "${sftp.local.directory}")
	private String localDirectory;

	public void copy() throws JSchException, IOException, SftpException {

		Session session = null;
		ChannelSftp sftpClient = null;
		try {
			session = openSession();
			sftpClient = openChannel(session);
			LOGGER.info("SFTP channel is opened for secure file transfer");
			@SuppressWarnings("unchecked")
			Vector<LsEntry> files = sftpClient.ls(remoteDirectory);
			copy(sftpClient, files, remoteDirectory, localDirectory);
		} finally {
			if (Objects.nonNull(sftpClient) || sftpClient.isConnected()) {
				sftpClient.exit();
				sftpClient = null;
			}
			if (Objects.nonNull(session) || session.isConnected()) {
				session.disconnect();
				session = null;
				LOGGER.info("SFTP session is closed.");
			}
		}
	}

	private Session openSession() throws JSchException, IOException {
		LOGGER.info("Opening SFTP channel for file transfer");
		JSch jsch = new JSch();
		Session session = jsch.getSession(username, remoteHost, remotePort);
		jsch.setKnownHosts("~/.ssh/known_hosts");
		Resource resource = new ClassPathResource(sshKeyFileName);
		jsch.addIdentity(resource.getFile().getAbsolutePath(), passphrase);
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.connect();
		return session;
	}

	private ChannelSftp openChannel(Session session) throws JSchException, IOException {
		Channel channel = session.openChannel("sftp");
		channel.connect();
		return (ChannelSftp) channel;
	}

	private void copy(ChannelSftp sftpClient, Vector<LsEntry> files, String sourcePath, String destPath)
			throws SftpException {
		LOGGER.info("Copying files from remote directory " + sourcePath);
		for (LsEntry file : files) {
			if (file.getFilename().startsWith(".")) {
				continue;
			}
			StringBuilder sourcePathBuilder = new StringBuilder(sourcePath).append(file.getFilename());
			StringBuilder destPathBuilder = new StringBuilder(destPath).append(file.getFilename());
			if (file.getAttrs().isDir()) {
				sourcePathBuilder.append("/");
				destPathBuilder.append("/");
				@SuppressWarnings("unchecked")
				Vector<LsEntry> nestedFiles = sftpClient.ls(sourcePathBuilder.toString());
				new File(destPathBuilder.toString()).mkdirs();
				copy(sftpClient, nestedFiles, sourcePathBuilder.toString(), destPathBuilder.toString());
			} else {
				File destFile = new File(destPathBuilder.toString());
				if (!destFile.exists() || (destFile.lastModified() != file.getAttrs().getMTime() * 60)) {
					sftpClient.get(sourcePathBuilder.toString(), destPathBuilder.toString());
				}
				LOGGER.info("File " + destPathBuilder.toString() + " was copied");
			}
		}
	}
}
