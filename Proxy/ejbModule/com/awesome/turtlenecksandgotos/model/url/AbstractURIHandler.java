package com.awesome.turtlenecksandgotos.model.url;

import java.net.URI;
import java.net.URISyntaxException;

import com.awesome.turtlenecksandgotos.logic.Handler;

public abstract class AbstractURIHandler<T> implements Handler<String, T> {

	@Override
	public void handle(String data, T entity) {
		try {
			handle(new URI(data), entity);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	protected abstract void handle(URI data, T entity);
}
