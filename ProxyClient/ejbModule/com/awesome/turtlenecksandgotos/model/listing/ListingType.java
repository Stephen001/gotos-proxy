package com.awesome.turtlenecksandgotos.model.listing;

import java.util.Locale;

public enum ListingType {
	FEATURED, LISTED, PENDING, REJECTED, HIDDEN;
	
	public static ListingType fromString(String data) {
		return valueOf(data.toUpperCase(Locale.ENGLISH));
	}
}
