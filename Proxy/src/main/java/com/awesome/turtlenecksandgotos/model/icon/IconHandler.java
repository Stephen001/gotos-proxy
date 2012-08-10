package com.awesome.turtlenecksandgotos.model.icon;

import java.net.URI;

import com.awesome.turtlenecksandgotos.model.url.AbstractURIHandler;

public final class IconHandler<T> extends AbstractURIHandler<T> {

	@Override
	protected void handle(URI data, T entity) {
		if (entity instanceof HasIcon) {
			HasIcon e = (HasIcon) entity;
			e.setIcon(data);
		}
	}
}
