package com.example.JAVA.Spring.vo;

import java.util.List;

import com.example.JAVA.Spring.entity.Gourmet_map;
import com.example.JAVA.Spring.entity.Gourmet_map2;

public class Gourmet_map_Response {
	
	Gourmet_map gourmet_map;
	
	Gourmet_map2 gourmet_map2;

	String message;

	String message2;

	List<Gourmet_map> gList;
	
	List<Gourmet_map2> gList2;

	List<Gourmet_map_Response2> gListR2;

	List<Gourmet_map_Response3> gListR3;

	public Gourmet_map_Response() {
		super();
	}

	public Gourmet_map_Response(String message) {
		super();
		this.message = message;

	}

	public Gourmet_map_Response(String message, String message2, List<Gourmet_map_Response2> gListR2) {
		super();
		this.message = message;
		this.message2 = message2;
		this.gListR2 = gListR2;
	}

	public Gourmet_map_Response(List<Gourmet_map_Response3> gListR3 , String message) {
		super();
		this.gListR3 = gListR3;
		this.message = message;
	}

	public Gourmet_map_Response(String message, List<Gourmet_map> gList) {
		super();
		this.message = message;
		this.gList = gList;
	}
	
	

	public Gourmet_map_Response(List<Gourmet_map2> gList2) {
		super();
		this.gList2 = gList2;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	public Gourmet_map getGourmet_map() {
		return gourmet_map;
	}

	public void setGourmet_map(Gourmet_map gourmet_map) {
		this.gourmet_map = gourmet_map;
	}

	public Gourmet_map2 getGourmet_map2() {
		return gourmet_map2;
	}

	public void setGourmet_map2(Gourmet_map2 gourmet_map2) {
		this.gourmet_map2 = gourmet_map2;
	}

	public List<Gourmet_map> getgList() {
		return gList;
	}

	public void setgList(List<Gourmet_map> gList) {
		this.gList = gList;
	}

	public List<Gourmet_map2> getgList2() {
		return gList2;
	}

	public void setgList2(List<Gourmet_map2> gList2) {
		this.gList2 = gList2;
	}

	public List<Gourmet_map_Response2> getgListR2() {
		return gListR2;
	}

	public void setgListR2(List<Gourmet_map_Response2> gListR2) {
		this.gListR2 = gListR2;
	}

	public List<Gourmet_map_Response3> getgListR3() {
		return gListR3;
	}

	public void setgListR3(List<Gourmet_map_Response3> gListR3) {
		this.gListR3 = gListR3;
	}



	
}
