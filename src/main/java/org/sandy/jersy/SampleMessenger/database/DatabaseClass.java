package org.sandy.jersy.SampleMessenger.database;

import java.util.HashMap;
import java.util.Map;

import org.sandy.jersy.SampleMessenger.model.Messages;
import org.sandy.jersy.SampleMessenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Messages> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	
	public static Map<Long, Messages> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

	
	
	
}
