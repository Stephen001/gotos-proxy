package com.awesome.turtlenecksandgotos.model.author;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class AuthorHandler<T> implements Handler<String, T> {

	@Override
	public void handle(final String data, final T entity) {
		if (entity instanceof HasAuthor) {
			final HasAuthor e = (HasAuthor) entity;
			e.setAuthor(data);
		}
	}
}
