package com.awesome.turtlenecksandgotos.model.screenshots;

import com.awesome.turtlenecksandgotos.logic.Handler;

public class ScreenshotsHandler<T> implements Handler<String, T> {

	@Override
	public void handle(String data, T entity) {
		if (entity instanceof HasScreenshots) {
			HasScreenshots e = (HasScreenshots) entity;
			e.setScreenshots(Integer.parseInt(data));
		}
	}
}
