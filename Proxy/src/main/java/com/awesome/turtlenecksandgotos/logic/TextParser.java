package com.awesome.turtlenecksandgotos.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TextParser<T> implements Parser<T> {
	private static final class SubParser<S, T> implements Parser<T> {
		public final Pattern name;
		public final Parser<S> parser;
		public final Class<S> clazz;
		public final Handler<S, T> handler;
		
		public SubParser(final Pattern name,
				         final Class<S> clazz,
				         final Parser<S> parser,
				         final Handler<S, T> handler) {
			this.name = name;
			this.clazz 	= clazz;
			this.parser = parser;
			this.handler = handler;
		}

		@Override
		public T parse(PushbackBufferedReader stream, T entity) throws IOException {
			try {
				S subEntity = clazz.newInstance();
				subEntity = parser.parse(stream, subEntity);
				handler.handle(subEntity, entity);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			return entity;
		}
	}
	
	private final List<SubParser<?, T>> subParsers = new ArrayList<SubParser<?, T>>();
	
	@Override
	public T parse(PushbackBufferedReader stream, T entity) throws IOException {
		do {
			String line = stream.readLine();
			if (line == null) {
				return entity;
			}
			line = line.trim();
			for (SubParser<?, T> subParser : subParsers) {
				if (subParser.name.matcher(line).matches()) {
					entity = subParser.parse(stream, entity);
					break;
				}
			}
		} while (stream.ready());
		return entity;
	}

	public <S> void registerHandler(Pattern name, Class<S> clazz, Parser<S> value, Handler<S, T> handler) {
		subParsers.add(new SubParser<S, T>(name, clazz, value, handler));
	}
}
