package com.awesome.turtlenecksandgotos.model.title;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class TitleHandler<T> implements Handler<String, T> {

	@Override
	public void handle(final String data, final T entity) {
		if (entity instanceof HasTitle) {
			final HasTitle e = (HasTitle) entity;
			e.setTitle(data);
		}
	}
}
