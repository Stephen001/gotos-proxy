package com.awesome.turtlenecksandgotos.model.lastplayed;

import java.util.Date;

import com.awesome.turtlenecksandgotos.model.date.AbstractDateHandler;

public final class LastPlayedHandler<T> extends AbstractDateHandler<T> {

	@Override
	protected void handle(Date date, T entity) {
		if (entity instanceof HasLastPlayed) {
			HasLastPlayed e = (HasLastPlayed) entity;
			e.setLastPlayed(date);
		}
	}
}
