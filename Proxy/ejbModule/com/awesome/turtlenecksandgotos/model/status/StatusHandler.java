package com.awesome.turtlenecksandgotos.model.status;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class StatusHandler<T> implements Handler<String, T> {

	@Override
	public void handle(final String data, final T entity) {
		if (entity instanceof HasStatus) {
			final HasStatus e = (HasStatus) entity;
			e.setStatus(data);
		}
	}
}
