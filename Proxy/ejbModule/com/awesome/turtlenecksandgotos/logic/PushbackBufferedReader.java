package com.awesome.turtlenecksandgotos.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.Deque;

public final class PushbackBufferedReader extends BufferedReader {
	private Deque<String> lines = new ArrayDeque<String>();
	
	public PushbackBufferedReader(Reader in) {
		super(in);
	}

	/* (non-Javadoc)
	 * @see java.io.BufferedReader#readLine()
	 */
	@Override
	public String readLine() throws IOException {
		if (!lines.isEmpty()) {
			return lines.removeLast();
		}
		return super.readLine();
	}
	
	public void unreadLine(String line) {
		lines.addLast(line);
	}
}
