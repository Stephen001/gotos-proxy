package com.awesome.turtlenecksandgotos.model.host;

import com.awesome.turtlenecksandgotos.logic.Handler;

public final class HostHandler<T> implements Handler<String, T> {

	@Override
	public void handle(String data, T entity) {
		if (entity instanceof HasHost) {
			HasHost e = (HasHost) entity;
			e.setHost(data);
		}
	}
}
