package com.n26.monefy.automation.utils;

import static java.lang.System.out;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	private Properties properties;

	public ReadProperties() {
		init();
	}

	private void init() {

		properties = new Properties();
		try (InputStream inputStream = new FileInputStream(new File("./src/test/resources/env.properties"))) {
			properties.load(inputStream);
		} catch (IOException e) {
		}
	}

	/**
	 * Gets the key from Config.properties related to chosen profile
	 *
	 * @param key
	 **/

	public String getProp(String key) {
		if ((key == null) || key.isEmpty()) {
			return "";
		} else {
			return properties.getProperty(key);

		}
	}

}
