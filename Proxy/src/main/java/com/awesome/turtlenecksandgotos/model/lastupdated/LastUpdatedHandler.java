package com.awesome.turtlenecksandgotos.model.lastupdated;

import java.util.Date;

import com.awesome.turtlenecksandgotos.model.date.AbstractDateHandler;
import com.awesome.turtlenecksandgotos.model.lastupdated.HasLastUpdated;

public class LastUpdatedHandler<T> extends AbstractDateHandler<T> {

	@Override
	protected void handle(Date date, T entity) {
		if (entity instanceof HasLastUpdated) {
			HasLastUpdated e = (HasLastUpdated) entity;
			e.setLastUpdated(date);
		}
	}
}
