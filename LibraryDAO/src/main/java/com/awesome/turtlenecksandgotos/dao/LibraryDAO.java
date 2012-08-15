package com.awesome.turtlenecksandgotos.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.awesome.turtlenecksandgotos.datamodel.library.LibraryMetadata;

@Stateful
public class LibraryDAO {
	@PersistenceContext(unitName="gotos-pu")
	private EntityManager em;
	
	public List<LibraryMetadata> getByAuthor(String author) {
		TypedQuery<LibraryMetadata> query = em.createNamedQuery("by-author", LibraryMetadata.class);
		query.setParameter(0, author);
		return query.getResultList();
	}
}
