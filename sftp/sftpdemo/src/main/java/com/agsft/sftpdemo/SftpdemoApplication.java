package com.agsft.sftpdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;

import org.apache.commons.vfs2.provider.sftp.IdentityRepositoryFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.IdentityRepository;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.KnownHosts;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.SftpStatVFS;

@SpringBootApplication
public class SftpdemoApplication {

	public static void main(String[] args) {

		try {

			String host = "127.0.0.1";
			String user = "bpawar";
			int port = 22;

			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, port);
			jsch.setKnownHosts("~/.ssh/known_hosts");
			ClassPathResource resource = new ClassPathResource("bpawarSsh");
			jsch.addIdentity(resource.getFile().getAbsolutePath(), "passphrase");
			ChannelSftp sftpClient = null;
			Channel channel = null;
//			session.setPassword("bpawar");

			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			channel = session.openChannel("sftp");
			channel.connect();
			sftpClient = (ChannelSftp) channel;
			@SuppressWarnings("unchecked")
			Vector<LsEntry> files = sftpClient.ls("/home/bpawar/Downloads/temp/");

			copy(sftpClient, files, "/home/bpawar/Downloads/temp/", "/home/bpawar/Downloads/sftp-transfer/");
//			System.out.println("Copied");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void copy(ChannelSftp sftpClient, Vector<LsEntry> files, String sourcePath, String destPath)
			throws SftpException {

		for (LsEntry file : files) {
			if (file.getFilename().startsWith(".")) {
				continue;
			}
			StringBuilder sourcePathBuilder = new StringBuilder(sourcePath).append(file.getFilename());
			StringBuilder destPathBuilder = new StringBuilder(destPath).append(file.getFilename());
			if (file.getAttrs().isDir()) {
				sourcePathBuilder.append("/");
				destPathBuilder.append("/");
				System.out.println("Reading folder : " + sourcePathBuilder.toString());
				@SuppressWarnings("unchecked")
				Vector<LsEntry> nestedFiles = sftpClient.ls(sourcePathBuilder.toString());
				new File(destPathBuilder.toString()).mkdirs();
				copy(sftpClient, nestedFiles, sourcePathBuilder.toString(), destPathBuilder.toString());
			} else {
				File destFile = new File(destPathBuilder.toString());
				System.out.println(destFile.getName() + " : Source lastModified: " + destFile.lastModified());
				System.out.println(file.getFilename() + " : Destination getATime: " + file.getAttrs().getATime());
				System.out.println(
						file.getFilename() + " : Destination getAtimeString: " + file.getAttrs().getAtimeString());
				System.out.println(file.getFilename() + " : Destination getMTime: " + file.getAttrs().getMTime());
				System.out.println(
						file.getFilename() + " : Destination getMtimeString: " + file.getAttrs().getMtimeString());
				System.out.println("Coping file " + sourcePathBuilder.toString() + " to " + destPathBuilder.toString());

				System.out.println("---------------------------");
				if (!destFile.exists() || destFile.lastModified() != file.getAttrs().getMTime()) {
					sftpClient.get(sourcePathBuilder.toString(), destPathBuilder.toString());
				}
			}
		}

	}

}
