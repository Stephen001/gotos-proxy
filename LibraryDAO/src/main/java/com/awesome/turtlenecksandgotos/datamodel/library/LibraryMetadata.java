package com.awesome.turtlenecksandgotos.datamodel.library;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	private String coverPage;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpstream;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDated;
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy="metadata")
	@OrderBy("version DESC")
	private Set<LibraryVersion> versions;
	
	@OneToOne(cascade={CascadeType.ALL})
	private LibraryVersion latestVersion;

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

	public String getCoverPage() {
		return coverPage;
	}

	public void setCoverPage(String coverPage) {
		this.coverPage = coverPage;
	}

	public Date getCreatedDated() {
		return createdDated;
	}

	public void setCreatedDated(Date createdDated) {
		this.createdDated = createdDated;
	}

	public Date getLastUpstream() {
		return lastUpstream;
	}

	public void setLastUpstream(Date lastUpstream) {
		this.lastUpstream = lastUpstream;
	}

	public Set<LibraryVersion> getVersions() {
		return versions;
	}

	public void setVersions(Set<LibraryVersion> versions) {
		this.versions = versions;
	}

	public LibraryVersion getLatestVersion() {
		return latestVersion;
	}

	public void setLatestVersion(LibraryVersion latestVersion) {
		this.latestVersion = latestVersion;
	}
}
