package com.awesome.turtlenecksandgotos.model.tags;

import java.util.List;

import com.awesome.turtlenecksandgotos.model.list.AbstractListHandler;

public final class TagsHandler<T> extends AbstractListHandler<T> {

	@Override
	protected void handleList(List<String> list, T entity) {
		if (entity instanceof HasTags) {
			HasTags e = (HasTags) entity;
			Tags tags = new Tags();
			tags.setTag(list);
			e.setTags(tags);
		}
	}
}
