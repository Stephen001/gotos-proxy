package com.awesome.turtlenecksandgotos.model.hubtype;

import java.util.Locale;

public enum HubType {
	LIBRARY, DEMO, GAME;
	
	public static HubType fromString(String data) {
		return valueOf(data.toUpperCase(Locale.ENGLISH));
	}
}
