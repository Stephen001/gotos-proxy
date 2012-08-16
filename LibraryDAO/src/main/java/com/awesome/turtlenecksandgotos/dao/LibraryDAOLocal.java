package com.awesome.turtlenecksandgotos.dao;

import java.util.List;

import com.awesome.turtlenecksandgotos.datamodel.library.LibraryMetadata;
import com.awesome.turtlenecksandgotos.model.DeveloperHub;

public interface LibraryDAOLocal {
	public List<LibraryMetadata> getByAuthor(String author);
	
	public LibraryMetadata createOrGet(String name, DeveloperHub hub);
}
