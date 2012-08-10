package com.awesome.turtlenecksandgotos.model.serverversion;

import com.awesome.turtlenecksandgotos.logic.Handler;

public final class ServerVersionHandler<T> implements Handler<String, T> {

	@Override
	public void handle(String data, T entity) {
		if (entity instanceof HasServerVersion) {
			HasServerVersion e = (HasServerVersion) entity;
			e.setServerVersion(Integer.parseInt(data));
		}
	}
}
