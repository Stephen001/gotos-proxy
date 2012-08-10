package com.awesome.turtlenecksandgotos.model.world;

import java.net.URI;

import javax.xml.bind.annotation.XmlType;

import com.awesome.turtlenecksandgotos.model.host.HasHost;
import com.awesome.turtlenecksandgotos.model.players.HasPlayers;
import com.awesome.turtlenecksandgotos.model.players.Players;
import com.awesome.turtlenecksandgotos.model.serverversion.HasServerVersion;
import com.awesome.turtlenecksandgotos.model.status.HasStatus;
import com.awesome.turtlenecksandgotos.model.url.HasURI;

@XmlType
public class World implements HasURI, HasStatus, HasPlayers, HasHost, HasServerVersion {
	private URI url;
	private String status;
	private Players players;
	private String host;
	private int serverVersion;
	
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

	@Override
	public Players getPlayers() {
		return players;
	}

	@Override
	public void setPlayers(Players players) {
		this.players = players;
	}

	@Override
	public String getHost() {
		return host;
	}

	@Override
	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public int getServerVersion() {
		return serverVersion;
	}

	@Override
	public void setServerVersion(int serverVersion) {
		this.serverVersion = serverVersion;
	}
}
