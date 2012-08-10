package com.awesome.turtlenecksandgotos.model.list;

import java.util.Arrays;
import java.util.List;

import com.awesome.turtlenecksandgotos.logic.Handler;

public abstract class AbstractListHandler<T> implements Handler<String, T> {	
	
	@Override
	public void handle(String data, T entity) {
		if (data.startsWith("list(") && data.endsWith(")")) {
			data = data.replaceFirst("list\\(", "").replaceFirst("\\)$", "").replaceAll("\\\"", "");
			List<String> list = Arrays.asList(data.split(","));
			for (int i = 0; i < list.size(); i++) {
				list.set(i, list.get(i).trim());
			}
			handleList(list, entity);
		}	
	}

	protected abstract void handleList(List<String> list, T entity);
}
