package com.example.JAVA.Spring.test.service.ifs;

import com.example.JAVA.Spring.vo.Gourmet_map_Response;

public interface Gourmet_map_service {

	// �V���X�ƕs��ܕ]�J --> String storeName, String city
	public Gourmet_map_Response addStoreAndCity(String storeName, String city);

	// �V���`�y�o�]�J --> String name, String itme, int price , int itemreview
	public Gourmet_map_Response addItmeInfo(String name, String item, int price, double itemreview);

	// ���p��s�r�q�X�Ǝ��u --> String city
	public Gourmet_map_Response searchCity(String city);

	// ���p�X�ƕ]�J�r�q�X�Ǝ��u --> double review
	public Gourmet_map_Response searchReview(double review);

	// ���p�X�ƕ]�J�r�q�o�`�y�]�J�X�Ǝ��u --> double review , double itemreview
	public Gourmet_map_Response searchReviewAndItemreview(double review, double itemreview);
	
	public Gourmet_map_Response deleteStore(String storeName);

	
}
