package com.awesome.turtlenecksandgotos.model.date;

import java.util.Date;

public class DateHandler<T> extends AbstractDateHandler<T> {

	@Override
	protected void handle(Date date, T entity) {
		if (entity instanceof HasDate) {
			HasDate e = (HasDate) entity;
			e.setDate(date);
		}
	}
}
