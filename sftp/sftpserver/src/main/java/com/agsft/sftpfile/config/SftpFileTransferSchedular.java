package com.agsft.sftpfile.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.agsft.sftpfile.util.FileCopier;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

/**
 * @author Balasaheb Pawar
 * @date 22 Sep 2018
 */
@Component
@EnableScheduling
public class SftpFileTransferSchedular {

	@Autowired
	private FileCopier fileCopier;

	@Scheduled(cron = "${sftp.polling.interval.expression}")
	public void transferFiles() throws JSchException, IOException, SftpException {
		fileCopier.copy();
	}
}
