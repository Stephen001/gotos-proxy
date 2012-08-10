package com.awesome.turtlenecksandgotos.model.video;

import java.net.URI;

import com.awesome.turtlenecksandgotos.model.url.AbstractURIHandler;

public final class VideoHandler<T> extends AbstractURIHandler<T> {

	@Override
	protected void handle(URI data, T entity) {
		if (entity instanceof HasVideo) {
			HasVideo e = (HasVideo) entity;
			e.setVideo(data);
		}
	}
}
