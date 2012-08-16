package com.awesome.turtlenecksandgotos.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.awesome.turtlenecksandgotos.datamodel.library.LibraryMetadata;
import com.awesome.turtlenecksandgotos.model.DeveloperHub;
import com.awesome.turtlenecksandgotos.model.general.General;

@Stateful
public class LibraryDAO implements LibraryDAOLocal {
	@PersistenceContext(unitName="gotos-pu")
	private EntityManager em;
	
	public List<LibraryMetadata> getByAuthor(String author) {
		TypedQuery<LibraryMetadata> query = em.createNamedQuery("by-author", LibraryMetadata.class);
		query = query.setParameter("author", author);
		return query.getResultList();
	}
	
	public LibraryMetadata createOrGet(String name, DeveloperHub hub) {
		General entry = hub.getGeneral();
		TypedQuery<LibraryMetadata> query = em.createNamedQuery("by-comp-id", LibraryMetadata.class);
		query = query.setParameter("author", entry.getAuthor());
		query = query.setParameter("name", name);
		LibraryMetadata metadata;
		List<LibraryMetadata> list = query.getResultList();
		if (!list.isEmpty()) {
			metadata = list.get(0);
		} else {
			metadata = new LibraryMetadata();
			metadata.setAuthor(entry.getAuthor());
			metadata.setDescription(entry.getShortDescription());
			metadata.setPrintableName(entry.getTitle());
			metadata.setName(name);
			em.persist(metadata);
		}
		return metadata;
	}
}
