package com.awesome.turtlenecksandgotos.logic;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TextSectionParser<T> implements Parser<T> {
	private Map<String, Handler<String, T>> matches = new HashMap<String, Handler<String, T>>();
	
	public T parse(final PushbackBufferedReader stream, final T entity) throws IOException {
		do {
			String line = stream.readLine();
			if (line == null) {
				return entity;
			}
			line = line.trim();
			int divide = line.indexOf('=');
			if (divide < 0) {
				stream.unreadLine(line);
				return entity;
			}
			String key = line.substring(0, divide - 1).trim();
			String value = line.substring(divide + 1).trim();
			if (value.startsWith("\"")) {
				value = value.substring(1, value.length() - 1);
			}
			if (value.contains("\\\"")) {
				value = value.replaceAll("\\\\\"", "\"");
			}
			if (value.contains("\\n")) {
				value = value.replaceAll("\\\\n", "\n");
			}
			Handler<String, T> handler = matches.get(key);
			if (handler != null) {
				handler.handle(value, entity);
			}
		} while (stream.ready());
		return entity;
	}
	
	public void registerHandler(final String name, final Handler<String, T> handler) {
		matches.put(name, handler);
	}
}
