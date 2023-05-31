package com.example.JAVA.Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JAVA.Spring.test.service.ifs.Gourmet_map_service;
import com.example.JAVA.Spring.vo.Gourmet_map_Requsest;
import com.example.JAVA.Spring.vo.Gourmet_map_Response;

@CrossOrigin
@RestController
public class Gourmet_map_controller {

	@Autowired
	private Gourmet_map_service gourmet_map_service;

	@PostMapping(value = "add_store")
	public Gourmet_map_Response addStoreAndCity(@RequestBody Gourmet_map_Requsest requsest) {

		return gourmet_map_service.addStoreAndCity(requsest.getStoreName(), requsest.getCity());

	}

	@PostMapping(value = "add_item")
	public Gourmet_map_Response addItmeInfo(@RequestBody Gourmet_map_Requsest requsest) {

		return gourmet_map_service.addItmeInfo(requsest.getName(), requsest.getItem(), requsest.getPrice(),
				requsest.getItemreview());

	}

	@PostMapping(value = "search_city")
	public Gourmet_map_Response searchCity(@RequestBody Gourmet_map_Requsest requsest) {

		return gourmet_map_service.searchCity(requsest.getCity());
	}

	@PostMapping(value = "search_review")
	public Gourmet_map_Response searchReview(@RequestBody Gourmet_map_Requsest requsest) {

		return gourmet_map_service.searchReview(requsest.getReview());

	}

	@PostMapping(value = "search_review_Itemreview")
	public Gourmet_map_Response searchReviewAndItemreview(@RequestBody Gourmet_map_Requsest requsest) {

		return gourmet_map_service.searchReviewAndItemreview(requsest.getReview(), requsest.getItemreview());
	}

	@PostMapping(value = "delete_store")
	public Gourmet_map_Response deleteStore(@RequestBody Gourmet_map_Requsest requsest) {

		return gourmet_map_service.deleteStore(requsest.getStoreName());

	}

}