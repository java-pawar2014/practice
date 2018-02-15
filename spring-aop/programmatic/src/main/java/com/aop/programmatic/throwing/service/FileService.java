package com.aop.programmatic.throwing.service;

import java.io.File;
import java.io.IOException;

public class FileService {

	public File load(String fileName) throws IOException {
		File file = null;

		file = new File(fileName);

		file.createNewFile();

		return file;
	}
}
