package com.example.JAVA.Spring.vo;

public class Gourmet_map_Response2 {

	private String storeName;

	private double review;

	private String item;

	private int price;

	private double itemreview;

	public Gourmet_map_Response2() {
		super();
	}

	public Gourmet_map_Response2(String storeName, double review, String item, int price, double itemreview) {
		super();
		this.storeName = storeName;
		this.review = review;
		this.item = item;
		this.price = price;
		this.itemreview = itemreview;
	}

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
