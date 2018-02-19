package com.springcore.ioc.source.loader;

import java.io.IOException;
import java.util.Properties;

public class MetadataLoader {

	private static final String FILE_PATH = "com/springcore/ioc/source/class.properties";

	private Properties classMetadata;
	private static MetadataLoader metadataLoader;

	public void load(String metadataFile) {
		classMetadata = new Properties();
		try {
			if (metadataFile == null) {
				/**
				 * load from default file
				 */
				classMetadata.load(MetadataLoader.class.getClassLoader().getResourceAsStream(FILE_PATH));
				System.out.println("Metadata loaded from source :\n\t>> " + FILE_PATH);
			} else {
				classMetadata.load(MetadataLoader.class.getClassLoader().getResourceAsStream(metadataFile));
				System.out.println("Metadata loaded from source :\n\t>> " + metadataFile);
			}
		} catch (IOException cause) {
			System.out.println(cause);
		}
	}

	public static MetadataLoader getMetadataLoader() {

		if (metadataLoader == null) {
			synchronized (MetadataLoader.class) {
				if (metadataLoader == null) {
					metadataLoader = new MetadataLoader();
				}
			}
		}
		System.out.println("MetadataLoader initialized.");
		return metadataLoader;
	}

	public Properties getClassMetadata() {
		return classMetadata;
	}
}
