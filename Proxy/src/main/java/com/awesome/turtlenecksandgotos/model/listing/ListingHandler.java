package com.awesome.turtlenecksandgotos.model.listing;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class ListingHandler<T> implements Handler<String, T> {

	@Override
	public void handle(final String data, final T entity) {
		if (entity instanceof HasListingType) {
			final HasListingType e = (HasListingType) entity;
			e.setListing(ListingType.fromString(data));
		}
	}
}
