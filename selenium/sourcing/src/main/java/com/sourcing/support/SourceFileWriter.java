package com.sourcing.support;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writes the source to the file.
 * 
 * @author bpawar
 *
 */
public class SourceFileWriter {

	/**
	 * Looks for given file path and creates file for <i>fileName</i>.<br>
	 * Writes the <i>source</i> to file, {@link Throwable} terminates execution if
	 * fails to write.
	 * 
	 * @param source
	 *            The {@link String} data to write
	 * @param filePath
	 *            The destination path of the {@link File}
	 * @param fileName
	 *            Actual file name to write the data
	 */
	public static void write(String source, String filePath, String fileName) {
		FileWriter writer = null;
		File file = null;

		try {
			file = new File(filePath + fileName);
			file.setWritable(true);
			file.setReadable(true);
			writer = new FileWriter(file);
			writer.write(source);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("Failed to write source file.");
			e.printStackTrace();
		}
	}
}
