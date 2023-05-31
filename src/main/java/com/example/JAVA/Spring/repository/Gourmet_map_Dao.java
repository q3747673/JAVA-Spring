package com.example.JAVA.Spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JAVA.Spring.entity.Gourmet_map;

@Repository
public interface Gourmet_map_Dao extends JpaRepository<Gourmet_map, String> {

//	public Gourmet_map findByNameAndCity(String name , String city);

	public Optional<Gourmet_map> findAllByStoreName(String storeName);

	public List<Gourmet_map> findAllByCityContaining(String city);

	public List<Gourmet_map> findAllByReviewGreaterThanEqualOrderByReviewDesc(double review);
	
	public Optional<Gourmet_map> findByCity(String city);
	
	public Optional<Gourmet_map> findByReview(double review);
	
}
