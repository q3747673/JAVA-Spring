package com.example.JAVA.Spring.vo;

public class Gourmet_map_Requsest {

	private String storeName;

	private String city;

	private double review;

	private String name;

	private String item;

	private int price;

	private double itemreview;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public double getReview() {
		return review;
	}

	public void setReview(double review) {
		this.review = review;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
