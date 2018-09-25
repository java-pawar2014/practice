package com.agsft.sftpfile.config;

import java.io.File;
import java.nio.file.FileVisitOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.RecursiveDirectoryScanner;
import org.springframework.integration.file.filters.AcceptOnceFileListFilter;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.filters.SftpSimplePatternFileListFilter;
import org.springframework.integration.sftp.inbound.SftpInboundFileSynchronizer;
import org.springframework.integration.sftp.inbound.SftpInboundFileSynchronizingMessageSource;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import com.agsft.sftpfile.RecursiveDirectoryScannerImpl;
import com.jcraft.jsch.ChannelSftp.LsEntry;

/**
 * @author bpawar
 * @since 19-Sep-2018
 */
@Configuration
public class SFTPConfiguration {

	@Value("${sftp.remote.host}")
	private String sftpRemoteHostAddress;

	@Value("${sftp.remote.port}")
	private int sftpRemotePort;

	@Value("${sftp.remote.user}")
	private String sftpRemoteUser;

	@Value("${sftp.remote.privateKey}")
	private String sftpRemotePrivateKey;

	@Value("${sftp.remote.privateKeyPassphrase}")
	private String sftpRemotePrivateKeyPassphrase;

	@Value("${sftp.remote.directory.download}")
	private String sftpRemoteDirectoryDownload;

	@Value("${sftp.remote.directory.download.filter:*.*}")
	private String sftpRemoteDirectoryDownloadFilter;

	@Value("${sftp.local.directory.download}")
	private String sftpLocalDirectoryDownload;

	@Bean
	public SessionFactory<LsEntry> sftpSessionFactory() {

		ClassPathResource sshResource = new ClassPathResource(sftpRemotePrivateKey);
		DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
		factory.setHost(sftpRemoteHostAddress);
		factory.setPort(sftpRemotePort);
		factory.setUser(sftpRemoteUser);
		factory.setPrivateKey(sshResource);
		factory.setPrivateKeyPassphrase(sftpRemotePrivateKeyPassphrase);
		factory.setAllowUnknownKeys(true);

		factory.setKnownHosts("~/.ssh/known_hosts");
		return new CachingSessionFactory<LsEntry>(factory);

	}

	@Bean
	public SftpInboundFileSynchronizer sftpInboundFileSynchronizer() {

		SftpInboundFileSynchronizer fileSynchronizer = new SftpInboundFileSynchronizer(sftpSessionFactory());
		fileSynchronizer.setDeleteRemoteFiles(false); // Restrict moving file
		fileSynchronizer.setPreserveTimestamp(true); // Transfer file if modified
		fileSynchronizer.setRemoteDirectory(sftpRemoteDirectoryDownload);
		fileSynchronizer.setFilter(new SftpSimplePatternFileListFilter(sftpRemoteDirectoryDownloadFilter));
//		fileSynchronizer.synchronizeToLocalDirectory(new File(sftpLocalDirectoryDownload));
		return fileSynchronizer;
	}

	@Bean
	@InboundChannelAdapter(channel = "fetchRecursive", poller = @Poller(cron = "0/5 * * * * *"))
	public MessageSource<File> sftpMessageSource() {

		SftpInboundFileSynchronizingMessageSource source = new SftpInboundFileSynchronizingMessageSource(
				sftpInboundFileSynchronizer());
		source.setLocalDirectory(new File(sftpLocalDirectoryDownload));
		source.setAutoCreateLocalDirectory(true);
		AcceptOnceFileListFilter<File> filter = new AcceptOnceFileListFilter<File>();
		RecursiveDirectoryScannerImpl scanner = new RecursiveDirectoryScannerImpl();
		scanner.setFileVisitOptions(FileVisitOption.FOLLOW_LINKS);

		scanner.setMaxDepth(50);
		scanner.setFilter(filter);
		source.setLocalFilter(filter);
		source.setScanner(scanner);
		return source;
	}

	@Bean
	@ServiceActivator(inputChannel = "fetchRecursive")
	public MessageHandler resultFileHandler() {
		return new MessageHandler() {
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				System.out.println(message);
			}
		};
	}

}
