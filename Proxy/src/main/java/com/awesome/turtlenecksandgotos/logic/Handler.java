package com.awesome.turtlenecksandgotos.logic;

public interface Handler<S, T> {
	public void handle(S data, T entity);
}
