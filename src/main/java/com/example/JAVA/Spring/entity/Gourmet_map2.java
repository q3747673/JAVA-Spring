package com.example.JAVA.Spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "gourmet_map2")
@IdClass(value = Gourmet_mapId.class)
public class Gourmet_map2 {
	/**
	 * 
	 */

	@Id
	@Column(name = "name")
	@JsonProperty("name")
	private String name;

	@Id
	@Column(name = "item")
	@JsonProperty("itme")
	private String item;

	@Column(name = "price")
	private int price;

	@Column(name = "itemreview")
	private double itemreview;

	public Gourmet_map2() {
		super();
	}

	public Gourmet_map2(String name, String item, int price, double itemreview) {
		super();
		this.name = name;
		this.item = item;
		this.price = price;
		this.itemreview = itemreview;
	}

	public Gourmet_map2(double itemreview) {
		super();
		this.itemreview = itemreview;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getItemreview() {
		return itemreview;
	}

	public void setItemreview(double itemreview) {
		this.itemreview = itemreview;
	}

}
