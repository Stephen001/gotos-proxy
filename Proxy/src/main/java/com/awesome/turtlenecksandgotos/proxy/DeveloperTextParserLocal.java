package com.awesome.turtlenecksandgotos.proxy;

import java.io.IOException;
import java.io.InputStream;

import javax.ejb.Local;

import com.awesome.turtlenecksandgotos.model.DeveloperHub;

@Local
public interface DeveloperTextParserLocal {
	public DeveloperHub parse(final InputStream stream) throws IOException;
}
