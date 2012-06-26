package com.awesome.turtlenecksandgotos.model.freedownload;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class FreeDownloadHandler<T> implements Handler<String, T> {

	@Override
	public void handle(String data, T entity) {
		if (entity instanceof IsFreeDownload) {
			IsFreeDownload e = (IsFreeDownload) entity;
			e.setFreeDownload(Integer.parseInt(data) != 0);
		}
	}
}
