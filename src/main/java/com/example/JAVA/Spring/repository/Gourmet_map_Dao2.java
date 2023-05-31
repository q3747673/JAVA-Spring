package com.example.JAVA.Spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JAVA.Spring.entity.Gourmet_map;
import com.example.JAVA.Spring.entity.Gourmet_map2;
import com.example.JAVA.Spring.entity.Gourmet_mapId;

@Repository
public interface Gourmet_map_Dao2 extends JpaRepository<Gourmet_map2,Gourmet_mapId> {

	public Gourmet_map2 findByNameAndItem(String name, String item);

	public List <Gourmet_map2> findAllByName(String name);

	public List<Gourmet_map2> findAllByItemreviewGreaterThanEqualOrderByItemreviewDesc(double itemreview);
	
	public List<Gourmet_map2> findByName(String storeName);
	
	public Optional<Gourmet_map2> findByItemreview(double itemreview);
	
}
