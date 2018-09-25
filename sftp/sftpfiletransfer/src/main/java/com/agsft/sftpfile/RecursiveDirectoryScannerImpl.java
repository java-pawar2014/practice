/**
 * 
 */
package com.agsft.sftpfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.integration.file.RecursiveDirectoryScanner;
import org.springframework.integration.file.filters.AbstractFileListFilter;
import org.springframework.integration.file.filters.FileListFilter;
import org.springframework.util.Assert;

/**
 * @author bpawar
 * @since 20-Sep-2018
 */
public class RecursiveDirectoryScannerImpl extends RecursiveDirectoryScanner {

	private int maxDepth = Integer.MAX_VALUE;

	private FileVisitOption[] fileVisitOptions = new FileVisitOption[0];

	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}

	public void setFileVisitOptions(FileVisitOption... fileVisitOptions) {
		Assert.notNull(fileVisitOptions, "'fileVisitOptions' must not be null");
		this.fileVisitOptions = Arrays.copyOf(fileVisitOptions, fileVisitOptions.length);
	}

	@Override
	public List<File> listFiles(File directory) throws IllegalArgumentException {
		FileListFilter<File> filter = getFilter();
		boolean supportAcceptFilter = filter instanceof AbstractFileListFilter;
		try (Stream<Path> pathStream = Files.walk(directory.toPath(), this.maxDepth, this.fileVisitOptions);) {
			Stream<File> fileStream = pathStream.skip(1).map(Path::toFile)
					.filter(file -> !supportAcceptFilter || ((AbstractFileListFilter<File>) filter).accept(file));

			if (supportAcceptFilter) {
				return fileStream.collect(Collectors.toList());
			} else {
				return filter.filterFiles(fileStream.toArray(File[]::new));
			}
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
