package com.awesome.turtlenecksandgotos.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.awesome.turtlenecksandgotos.datamodel.library.LibraryMetadata;
import com.awesome.turtlenecksandgotos.datamodel.library.LibraryVersion;
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
		boolean needsPersist = false;
		if (!list.isEmpty()) {
			metadata = list.get(0);
			if (metadata.getLastUpstream().before(entry.getLastUpdated())) {
				metadata.setLastUpstream(entry.getLastUpdated());
				LibraryVersion version = makeVersion(entry, metadata);
				metadata.setLatestVersion(version);
				metadata.getVersions().add(version);
				needsPersist = true;
			}
		} else {
			metadata = new LibraryMetadata();
			metadata.setAuthor(entry.getAuthor());
			metadata.setName(name);
			metadata.setCreatedDated(entry.getDate());
			metadata.setLastUpstream(entry.getLastUpdated());
			LibraryVersion version = makeVersion(entry, metadata);
			Set<LibraryVersion> versions = new HashSet<LibraryVersion>();
			versions.add(version);
			metadata.setLatestVersion(version);
			metadata.setVersions(versions);
			needsPersist = true;
		}
		needsPersist |= checkAndUpdate(metadata, entry);
		if (needsPersist) {
			em.persist(metadata);
		}
		return metadata;
	}

	private LibraryVersion makeVersion(General entry, LibraryMetadata metadata) {
		LibraryVersion version = new LibraryVersion();
		version.setVersion(entry.getVersion());
		version.setMetadata(metadata);
		return version;
	}
	
	private boolean checkAndUpdate(LibraryMetadata metadata, General entry) {
		boolean update = false;
		if (metadata.getDescription() == null || !metadata.getDescription().equals(entry.getShortDescription())) {
			metadata.setDescription(entry.getShortDescription());
			update = true;
		}
		if (metadata.getPrintableName() == null || !metadata.getPrintableName().equals(entry.getTitle())) {
			metadata.setPrintableName(entry.getTitle());
			update = true;
		}
		if (metadata.getCoverPage() == null || !metadata.getCoverPage().equals(entry.getLongDescription())) {
			metadata.setCoverPage(entry.getLongDescription());
			update = true;
		}
		return update;
	}
}
