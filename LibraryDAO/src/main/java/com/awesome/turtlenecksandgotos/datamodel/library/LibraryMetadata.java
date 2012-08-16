package com.awesome.turtlenecksandgotos.datamodel.library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="by-author", query="SELECT u FROM LibraryMetadata u WHERE u.author = :author"),
	@NamedQuery(name="by-comp-id", query="SELECT u FROM LibraryMetadata u WHERE u.author = :author AND u.name = :name")
	})
public class LibraryMetadata {
	@Id
	@GeneratedValue
	private int id;
	
	private String author;
	
	private String name;
	
	private String printableName;
	
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrintableName() {
		return printableName;
	}

	public void setPrintableName(String printableName) {
		this.printableName = printableName;
	}
}
