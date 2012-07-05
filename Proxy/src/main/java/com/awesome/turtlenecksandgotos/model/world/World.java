package com.awesome.turtlenecksandgotos.model.world;

import java.net.URI;

import javax.xml.bind.annotation.XmlType;

import com.awesome.turtlenecksandgotos.model.status.HasStatus;
import com.awesome.turtlenecksandgotos.model.uri.HasURI;

@XmlType
public class World implements HasURI, HasStatus {
	private URI url;
	private String status;
	
	@Override
	public URI getURL() {
		return url;
	}

	@Override
	public void setURL(URI url) {
		this.url = url;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}
}
