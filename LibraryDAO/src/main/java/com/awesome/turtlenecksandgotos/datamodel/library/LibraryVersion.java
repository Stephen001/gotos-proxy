package com.awesome.turtlenecksandgotos.datamodel.library;

import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LibraryVersion {
	@Id
	@GeneratedValue
	private int id;
	
	private URL url;
	
	private String version;
	
	private LibraryMetadata metadata;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public LibraryMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(LibraryMetadata metadata) {
		this.metadata = metadata;
	}
}
