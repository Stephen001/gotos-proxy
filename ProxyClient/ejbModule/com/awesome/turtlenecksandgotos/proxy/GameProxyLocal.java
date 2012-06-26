package com.awesome.turtlenecksandgotos.proxy;

import javax.ejb.Local;

import com.awesome.turtlenecksandgotos.model.GameHub;

@Local
public interface GameProxyLocal {
	public GameHub proxify(final String developer, final String hubname);
}
