package com.agsft.sftpcommons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

public class Test {

	static Properties props;
	{
		props = new Properties();
		try {
			props.load(new FileInputStream("src/main/resources/application.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Test test = new Test();

		test.startFTP("/home/user/Downloads/temp/");

	}

	public boolean startFTP(String fileToDownload) {

		StandardFileSystemManager manager = new StandardFileSystemManager();

		try {

			String serverAddress = props.getProperty("sftp.remote.host").trim();
			String userId = props.getProperty("sftp.remote.user").trim();
			String password = props.getProperty("sftp.remote.password").trim();
			String remoteDirectory = props.getProperty("sftp.remote.directory.download").trim();
			String localDirectory = props.getProperty("sftp.local.directory.download").trim();

			// Initializes the file manager
			manager.init();

			// Setup our SFTP configuration
			FileSystemOptions opts = new FileSystemOptions();
			SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(opts, "no");
			SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, true);
			SftpFileSystemConfigBuilder.getInstance().setTimeout(opts, 10000);

			// Create the SFTP URI using the host name, userid, password, remote path and
			// file name
			String sftpUri = "sftp://" + userId + ":" + password + "@" + serverAddress + "/" + remoteDirectory;

			// Create local file object
			String filepath = localDirectory;
			File file = new File(filepath);
			FileObject localFile = manager.resolveFile(file.getAbsolutePath());

			// Create remote file object
			FileObject remoteFile = manager.resolveFile(sftpUri, opts);
			if (remoteFile.isFolder()) {
				for (FileObject fileObject : remoteFile.getChildren()) {
					localFile = manager.resolveFile(localFile.getURL().getFile() + fileObject.getName(), opts);
					localFile.copyFrom(fileObject, Selectors.SELECT_SELF);
				}
			} else {
				localFile.copyFrom(remoteFile, Selectors.SELECT_SELF);
			}
			// Copy local file to sftp server
			System.out.println("File download successful");

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			manager.close();
		}

		return true;
	}

}
