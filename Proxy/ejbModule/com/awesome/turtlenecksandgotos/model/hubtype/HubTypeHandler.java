package com.awesome.turtlenecksandgotos.model.hubtype;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class HubTypeHandler<T> implements Handler<String, T> {

	@Override
	public void handle(final String data, final T entity) {
		if (entity instanceof HasHubType) {
			final HasHubType e = (HasHubType) entity;
			e.setHubType(HubType.fromString(data));
		}
	}
}
