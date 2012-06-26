package com.awesome.turtlenecksandgotos.model.longdesc;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class LongDescHandler<T> implements Handler<String, T> {

	@Override
	public void handle(String data, T entity) {
		if (entity instanceof HasLongDesc) {
			final HasLongDesc e = (HasLongDesc) entity;
			e.setLongDescription(data);
		}
	}
}
