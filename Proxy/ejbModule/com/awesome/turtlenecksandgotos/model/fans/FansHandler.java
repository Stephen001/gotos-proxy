package com.awesome.turtlenecksandgotos.model.fans;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class FansHandler<T> implements Handler<String, T> {

	@Override
	public void handle(String data, T entity) {
		if (entity instanceof HasFans) {
			HasFans e = (HasFans) entity;
			e.setFans(Integer.parseInt(data));
		}
	}
}
