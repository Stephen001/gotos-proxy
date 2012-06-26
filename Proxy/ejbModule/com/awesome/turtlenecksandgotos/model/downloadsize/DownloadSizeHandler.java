package com.awesome.turtlenecksandgotos.model.downloadsize;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class DownloadSizeHandler<T> implements Handler<String, T> {

	@Override
	public void handle(String data, T entity) {
		if (entity instanceof HasDownloadSize) {
			HasDownloadSize e = (HasDownloadSize) entity;
			e.setDownloadSize(Integer.parseInt(data));
		}
	}
}
