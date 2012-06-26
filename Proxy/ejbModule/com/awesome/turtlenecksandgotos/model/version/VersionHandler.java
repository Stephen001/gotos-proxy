package com.awesome.turtlenecksandgotos.model.version;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class VersionHandler<T> implements Handler<String, T> {

	@Override
	public void handle(final String data, final T entity) {
		if (entity instanceof HasVersion) {
			final HasVersion e = (HasVersion) entity;
			e.setVersion(data);
		}
	}
}
