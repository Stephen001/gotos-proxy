package com.awesome.turtlenecksandgotos.model.author;

import java.util.Arrays;
import java.util.List;

import com.awesome.turtlenecksandgotos.logic.Handler;

public abstract class ListHandler<T> implements Handler<String, T> {	
	
	@Override
	public void handle(String data, T entity) {
		if (data.startsWith("list(") && data.endsWith(")")) {
			data = data.replaceFirst("list(", "").replaceFirst(")$", "");
			handle(Arrays.asList(data.split(",")), entity);
		}	
	}

	protected abstract void handle(List<String> list, T entity);
}
