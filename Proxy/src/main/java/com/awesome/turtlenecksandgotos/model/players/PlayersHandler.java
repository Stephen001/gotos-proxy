package com.awesome.turtlenecksandgotos.model.players;

import java.util.List;

import com.awesome.turtlenecksandgotos.model.list.AbstractListHandler;

public final class PlayersHandler<T> extends AbstractListHandler<T> {

	@Override
	protected void handleList(List<String> data, T entity) {
		if (entity instanceof HasPlayers) {
			HasPlayers e = (HasPlayers) entity;
			Players players = new Players();
			players.setPlayer(data);
			e.setPlayers(players);
		}
	}
}
