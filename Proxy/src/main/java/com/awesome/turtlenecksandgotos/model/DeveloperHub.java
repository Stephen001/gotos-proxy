package com.awesome.turtlenecksandgotos.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.awesome.turtlenecksandgotos.model.general.General;
import com.awesome.turtlenecksandgotos.model.general.HasGeneralSection;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class DeveloperHub implements HasGeneralSection {
	private General general;

	@Override
	public General getGeneral() {
		return general;
	}

	@Override
	public void setGeneral(General general) {
		this.general = general;
	}
}
