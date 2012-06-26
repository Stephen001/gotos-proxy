package com.awesome.turtlenecksandgotos.model.world;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class WorldHandler<T> implements Handler<World, T> {

	@Override
	public void handle(World data, T entity) {
		if (entity instanceof HasWorld) {
			HasWorld e = (HasWorld) entity;
			e.setWorld(data);
		} else if (entity instanceof HasWorlds) {
			HasWorlds e = (HasWorlds) entity;
			Worlds worlds = e.getWorlds();
			if (worlds == null) {
				worlds = new Worlds();
				e.setWorlds(worlds);
			}
			worlds.getWorld().add(data);
		}
	}
}
