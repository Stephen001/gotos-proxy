package com.awesome.turtlenecksandgotos.model.multiplayer;

import com.awesome.turtlenecksandgotos.logic.Handler;

public final class IsMultiplayerHandler<T> implements Handler<String, T> {

	@Override
	public void handle(String data, T entity) {
		if (entity instanceof IsMultiplayer) {
			IsMultiplayer e = (IsMultiplayer) entity;
			e.setMultiplayer(Integer.parseInt(data) != 0);
		}
	}
}
