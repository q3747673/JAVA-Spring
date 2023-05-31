package com.example.JAVA.Spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "gourmet_map")
public class Gourmet_map {

	@Id
	@Column(name = "store_name")
	private String storeName;

	@Column(name = "review")
	private double review;

	@Column(name = "city")
	private String city;

	public Gourmet_map() {
		super();
	}

	
	public Gourmet_map(String storeName, String city) {
		super();
		this.storeName = storeName;
		this.city = city;
	}


	public Gourmet_map(String city) {
		super();
		this.city = city;
	}

	public Gourmet_map(double review) {
		super();
		this.review = review;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getReview() {
		return review;
	}

	public void setReview(double review) {
		this.review = review;
	}

}
