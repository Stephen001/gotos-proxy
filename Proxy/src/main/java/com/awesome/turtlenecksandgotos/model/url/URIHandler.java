package com.awesome.turtlenecksandgotos.model.url;

import java.net.URI;


public class URIHandler<T> extends AbstractURIHandler<T> {

	@Override
	protected void handle(URI data, T entity) {
		if (entity instanceof HasURI) {
			HasURI e = (HasURI) entity;
			e.setURL(data);
		}
	}
}
