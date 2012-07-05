package com.awesome.turtlenecksandgotos.proxy;

import javax.ejb.Local;

import com.awesome.turtlenecksandgotos.model.DeveloperHub;

@Local
public interface DeveloperProxyLocal {
	public DeveloperHub proxify(final String developer, final String hubname);
}
