package com.awesome.turtlenecksandgotos.model.players;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public final class Players {
	private List<String> player = new ArrayList<String>();
	
	public Players() {}

	public List<String> getPlayer() {
		return player;
	}

	public void setPlayer(List<String> player) {
		this.player = player;
	}
}
