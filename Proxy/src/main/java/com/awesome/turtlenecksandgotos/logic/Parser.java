package com.awesome.turtlenecksandgotos.logic;

import java.io.IOException;

public interface Parser<T> {
	public T parse(final PushbackBufferedReader stream, final T entity) throws IOException;
}
