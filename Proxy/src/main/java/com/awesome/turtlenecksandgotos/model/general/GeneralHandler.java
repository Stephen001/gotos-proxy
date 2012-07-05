package com.awesome.turtlenecksandgotos.model.general;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class GeneralHandler<T> implements Handler<General, T> {

	@Override
	public void handle(General data, T entity) {
		if (entity instanceof HasGeneralSection) {
			HasGeneralSection e = (HasGeneralSection) entity;
			e.setGeneral(data);
		}
	}
}
