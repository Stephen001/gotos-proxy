package com.awesome.turtlenecksandgotos.proxy;

import java.io.IOException;
import java.io.InputStream;

import javax.ejb.Local;

import com.awesome.turtlenecksandgotos.model.GameHub;

@Local
public interface GameTextParserLocal {
	public GameHub parse(final InputStream stream) throws IOException;
}
