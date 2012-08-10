package com.awesome.turtlenecksandgotos.model.smallicon;

import java.net.URI;

import com.awesome.turtlenecksandgotos.model.url.AbstractURIHandler;

public final class SmallIconHandler<T> extends AbstractURIHandler<T> {

	@Override
	protected void handle(URI data, T entity) {
		if (entity instanceof HasSmallIcon) {
			HasSmallIcon e = (HasSmallIcon) entity;
			e.setSmallIcon(data);
		}
	}
}
