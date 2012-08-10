package com.awesome.turtlenecksandgotos.model.tags;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public final class Tags {
	private List<String> tag = new ArrayList<String>();

	public Tags() {}
	
	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}
}
