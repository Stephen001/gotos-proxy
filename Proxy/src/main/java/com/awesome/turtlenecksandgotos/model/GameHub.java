package com.awesome.turtlenecksandgotos.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.awesome.turtlenecksandgotos.model.general.General;
import com.awesome.turtlenecksandgotos.model.general.HasGeneralSection;
import com.awesome.turtlenecksandgotos.model.world.HasWorlds;
import com.awesome.turtlenecksandgotos.model.world.Worlds;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class GameHub implements HasGeneralSection, HasWorlds {	
	private General general;
	private Worlds worlds;

	@Override
	public General getGeneral() {
		return general;
	}

	@Override
	public void setGeneral(General general) {
		this.general = general;
	}

	@Override
	public Worlds getWorlds() {
		return worlds;
	}

	@Override
	public void setWorlds(Worlds worlds) {
		this.worlds = worlds;
	}
}
