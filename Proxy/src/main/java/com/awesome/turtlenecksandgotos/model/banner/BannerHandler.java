package com.awesome.turtlenecksandgotos.model.banner;

import java.net.URI;

import com.awesome.turtlenecksandgotos.model.url.AbstractURIHandler;

public final class BannerHandler<T> extends AbstractURIHandler<T> {

	@Override
	protected void handle(URI data, T entity) {
		if (entity instanceof HasBanner) {
			HasBanner e = (HasBanner) entity;
			e.setBanner(data);
		}
	}
}
