package com.awesome.turtlenecksandgotos.model.downloads;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class DownloadsHandler<T> implements Handler<String, T> {

	@Override
	public void handle(String data, T entity) {
		if (entity instanceof HasDownloads) {
			HasDownloads e = (HasDownloads) entity;
			e.setDownloads(Integer.parseInt(data));
		}
	}
}
