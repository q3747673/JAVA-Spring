package com.example.JAVA.Spring.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Gourmet_mapId implements Serializable {

	private String name;

	private String item;

	public Gourmet_mapId() {
		super();
	}

	public Gourmet_mapId(String name, String item) {
		super();
		this.name = name;
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	
}
