package by.coach.controller;

import java.util.ResourceBundle;

public class ConfigurationManager {
	private final static ResourceBundle resBund = ResourceBundle
			.getBundle("resources.config");

	private ConfigurationManager() {
	}

	public static String getProperty(String key) {
		return resBund.getString(key);
	}

}
