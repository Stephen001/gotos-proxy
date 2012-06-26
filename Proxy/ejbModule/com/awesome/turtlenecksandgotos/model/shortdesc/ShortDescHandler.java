package com.awesome.turtlenecksandgotos.model.shortdesc;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class ShortDescHandler<T> implements Handler<String, T> {

	@Override
	public void handle(String data, T entity) {
		if (entity instanceof HasShortDesc) {
			final HasShortDesc e = (HasShortDesc) entity;
			e.setShortDescription(data);
		}
	}
}
