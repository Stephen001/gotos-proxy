package com.awesome.turtlenecksandgotos.model.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.awesome.turtlenecksandgotos.logic.Handler;

public abstract class AbstractDateHandler<T> implements Handler<String, T> {
	private final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
	
	@Override
	public void handle(String data, T entity) {
		try {
			handle(format.parse(data), entity);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	protected abstract void handle(Date date, T entity);
}
