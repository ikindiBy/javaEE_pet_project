package by.coach.controller;

import java.util.ResourceBundle;

public class MessageManager {
	private static final ResourceBundle resBund = ResourceBundle.getBundle("resources.messages");
	private MessageManager(){	}
	public static String getProperty(String key){
		return resBund.getString(key);
	}
}
