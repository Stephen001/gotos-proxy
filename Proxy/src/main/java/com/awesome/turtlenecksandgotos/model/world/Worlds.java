package com.awesome.turtlenecksandgotos.model.world;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlType
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Worlds {
	private List<World> world = new ArrayList<World>();
	
	public Worlds() {}
	
	public List<World> getWorld() {
		return world;
	}
	
	public void setWorld(List<World> worlds) {
		this.world = worlds;
	}
}
