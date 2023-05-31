package com.example.JAVA.Spring.test.service.ifs;

import com.example.JAVA.Spring.vo.Gourmet_map_Response;

public interface Gourmet_map_service {

	// Vú“X‰Æ•s•ïŠÜ•]™J --> String storeName, String city
	public Gourmet_map_Response addStoreAndCity(String storeName, String city);

	// VúŽ`êyäo•]™J --> String name, String itme, int price , int itemreview
	public Gourmet_map_Response addItmeInfo(String name, String item, int price, double itemreview);

	// —˜—péŽsrq“X‰ÆŽ‘u --> String city
	public Gourmet_map_Response searchCity(String city);

	// —˜—p“X‰Æ•]™Jrq“X‰ÆŽ‘u --> double review
	public Gourmet_map_Response searchReview(double review);

	// —˜—p“X‰Æ•]™JrqäoŽ`êy•]™J“X‰ÆŽ‘u --> double review , double itemreview
	public Gourmet_map_Response searchReviewAndItemreview(double review, double itemreview);
	
	public Gourmet_map_Response deleteStore(String storeName);

	
}
