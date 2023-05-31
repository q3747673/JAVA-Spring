package com.example.JAVA.Spring.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;

import com.example.JAVA.Spring.conststants.RtnCode;
import com.example.JAVA.Spring.entity.Gourmet_map;
import com.example.JAVA.Spring.entity.Gourmet_map2;
import com.example.JAVA.Spring.entity.Gourmet_mapId;
import com.example.JAVA.Spring.repository.Gourmet_map_Dao;
import com.example.JAVA.Spring.repository.Gourmet_map_Dao2;
import com.example.JAVA.Spring.test.service.ifs.Gourmet_map_service;
import com.example.JAVA.Spring.vo.Gourmet_map_Response2;
import com.example.JAVA.Spring.vo.Gourmet_map_Response3;
import com.example.JAVA.Spring.vo.Gourmet_map_Response;

@Service
public class Gourmet_map_service_impl implements Gourmet_map_service {

	@Autowired
	private Gourmet_map_Dao gourmet_map_Dao;

	@Autowired
	private Gourmet_map_Dao2 gourmet_map_Dao2;

	// 新增店家-->String storeName, String city
	@Override
	public Gourmet_map_Response addStoreAndCity(String storeName, String city) {
		// 判斷輸入的值是否是空的
		if (!StringUtils.hasText(storeName) || !StringUtils.hasText(city)) {

			return new Gourmet_map_Response(RtnCode.CANNOT_EMPTY.getMessage());
		}
		// 從資料庫比對資料
		Optional<Gourmet_map> checkStoreOp = gourmet_map_Dao.findById(storeName);

		// 判斷在資料庫中是否存在
		if (checkStoreOp.isPresent()) {
			return new Gourmet_map_Response(RtnCode.DATE_ERROR.getMessage());
		}
		// new出Gourmet_map把輸入的值加入倒Gourmet_map
		Gourmet_map gourmet_map = new Gourmet_map(storeName, city);

		gourmet_map_Dao.save(gourmet_map);
		return new Gourmet_map_Response(RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public Gourmet_map_Response addItmeInfo(String name, String item, int price, double itemreview) {

		// 比對輸入資料是否空白
		if (!StringUtils.hasText(name) || !StringUtils.hasText(item) || price <= 0 || itemreview <= 0) {

			return new Gourmet_map_Response(RtnCode.CANNOT_EMPTY.getMessage());
		}
		// 比對店家是否存在
		Optional<Gourmet_map> storeNameOp = gourmet_map_Dao.findAllByStoreName(name);

		// 如果不存在報告錯誤
		if (!storeNameOp.isPresent()) {
			return new Gourmet_map_Response(RtnCode.DATE_ERROR.getMessage());
		}

		// 判斷店家餐點有沒有大於3個
		List<Gourmet_map2> storeList = gourmet_map_Dao2.findAllByName(name);
		if (storeList.size() >= 3) {

			return new Gourmet_map_Response(RtnCode.DATE_ERROR.getMessage());
		}

		// 帶入雙主KEY新增餐點
		Gourmet_mapId gourmetPk = new Gourmet_mapId(name, item);

		// 判斷雙主KEY是否存在
		Optional<Gourmet_map2> gmapOp = gourmet_map_Dao2.findById(gourmetPk);

		if (gmapOp.isPresent()) {
			return new Gourmet_map_Response(RtnCode.DATE_ERROR.getMessage());

		}
		Gourmet_map2 gourmet_map2 = new Gourmet_map2(name, item, price, itemreview);

		gourmet_map_Dao2.save(gourmet_map2);

		// 計算餐廳評價
		List<Gourmet_map2> storeReview = gourmet_map_Dao2.findAllByName(name);

		// 餐點評價總和
		double total = 0;

		// 計算幾個餐點
		int i = 0;

		for (Gourmet_map2 storeInfo : storeReview) {

			total = total + storeInfo.getItemreview();
			i++;
		}

		// 計算平均
		double avg = total / i;

		avg = Math.round(avg * 10.0) / 10.0;

		// a的資料型態是Gourmet_map, OP是外的包裝所以要用get取裡面
		Gourmet_map a = storeNameOp.get();
		storeNameOp.get().setReview(avg);

		gourmet_map_Dao.save(storeNameOp.get());

		return new Gourmet_map_Response(RtnCode.SUCCESSFUL.getMessage());

	}

	@Override
	public Gourmet_map_Response searchCity(String city) {

		// 放要回傳的 裡面有五個參數
		List<Gourmet_map_Response2> searchCity = new ArrayList<>();

		if (!StringUtils.hasText(city)) {
			return new Gourmet_map_Response(RtnCode.DATE_ERROR.getMessage());
		}

		Optional<Gourmet_map> op = gourmet_map_Dao.findByCity(city);
		if (!op.isPresent()) {
			return new Gourmet_map_Response(RtnCode.DATE_ERROR.getMessage());
		}

		// 用城市找出資料-->包含 店家名稱 店家評價 餐點 餐點價格 餐點評價
		List<Gourmet_map> gDao = gourmet_map_Dao.findAllByCityContaining(city);

		// 從Dao2抓資料
		List<Gourmet_map2> itemInfo = gourmet_map_Dao2.findAll();

		// 搜尋gDao跟itemInfo的資料
		for (Gourmet_map i : gDao) {
			for (Gourmet_map2 j : itemInfo) {
				// 如果表1跟表2店名一樣
				if (i.getStoreName().equals(j.getName())) {
					// 就取得出店家名稱 店家評價 餐點 餐點價格 餐點評價
					Gourmet_map_Response2 gourmet_map_Requsest2 = new Gourmet_map_Response2(i.getStoreName(),
							i.getReview(), j.getItem(), j.getPrice(), j.getItemreview());
					// 加入List
					searchCity.add(gourmet_map_Requsest2);
				}
			}

		}

		return new Gourmet_map_Response(RtnCode.SUCCESSFUL.getMessage(), "搜尋成功", searchCity);
	}

	@Override
	public Gourmet_map_Response searchReview(double review) {

		List<Gourmet_map_Response3> reviewAllStore = new ArrayList<>();

		if (review <= 0) {
			return new Gourmet_map_Response(RtnCode.DATE_ERROR.getMessage());
		}
		Optional<Gourmet_map> op = gourmet_map_Dao.findByReview(review);
		if (!op.isPresent()) {
			return new Gourmet_map_Response(RtnCode.DATE_ERROR.getMessage());

		}

		List<Gourmet_map> gmapDao = gourmet_map_Dao.findAllByReviewGreaterThanEqualOrderByReviewDesc(review);

		List<Gourmet_map2> gmap2Dao = gourmet_map_Dao2.findAll();

		for (Gourmet_map i : gmapDao) {
			for (Gourmet_map2 j : gmap2Dao) {
				if (i.getStoreName().equals(j.getName())) {
					Gourmet_map_Response3 gourmet_map_Requsest3 = new Gourmet_map_Response3(i.getCity(),
							i.getStoreName(), i.getReview(), j.getItem(), j.getPrice(), j.getItemreview());

					reviewAllStore.add(gourmet_map_Requsest3);

				}

			}

		}

		return new Gourmet_map_Response(reviewAllStore, RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public Gourmet_map_Response searchReviewAndItemreview(double review, double itemreview) {

		List<Gourmet_map_Response3> all = new ArrayList<Gourmet_map_Response3>();

		if (review <= 0 || itemreview <= 0) {
			return new Gourmet_map_Response(RtnCode.DATE_ERROR.getMessage());
		}
		Optional<Gourmet_map> op = gourmet_map_Dao.findByReview(review);
		Optional<Gourmet_map2> op2 = gourmet_map_Dao2.findByItemreview(review);

		if (!op.isPresent() && op2.isPresent()) {

			return new Gourmet_map_Response(RtnCode.DATE_ERROR.getMessage());
		}

		List<Gourmet_map> searchReview = gourmet_map_Dao.findAllByReviewGreaterThanEqualOrderByReviewDesc(review);

		List<Gourmet_map2> searchItemreview = gourmet_map_Dao2
				.findAllByItemreviewGreaterThanEqualOrderByItemreviewDesc(itemreview);

		for (Gourmet_map i : searchReview) {
			for (Gourmet_map2 j : searchItemreview) {
				if (i.getStoreName().equals(j.getName())) {

					Gourmet_map_Response3 gourmet_map_Requsest3 = new Gourmet_map_Response3(i.getCity(),
							i.getStoreName(), i.getReview(), j.getItem(), j.getPrice(), j.getItemreview());

					all.add(gourmet_map_Requsest3);
				}
			}
		}

		return new Gourmet_map_Response(all, RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public Gourmet_map_Response deleteStore(String storeName) {
		List<Gourmet_map> list1 = new ArrayList<Gourmet_map>();
		List<Gourmet_map2> list2 = new ArrayList<Gourmet_map2>();

		Optional<Gourmet_map> op = gourmet_map_Dao.findById(storeName);
		if (!op.isPresent()) {
			return new Gourmet_map_Response(RtnCode.DATE_ERROR.getMessage());

		}
		list1.add(op.get());

		Gourmet_mapId gPK = new Gourmet_mapId();

		List<Gourmet_map2> gList2 = gourmet_map_Dao2.findByName(storeName);

		list2.addAll(gList2);

		for (Gourmet_map i : list1) {
			String deleteStore1 = i.getStoreName();
			for (Gourmet_map2 j : list2) {
				String deleteStore2 = j.getName();
				if (deleteStore1.equals(deleteStore2)) {

					gourmet_map_Dao.delete(i);

					gourmet_map_Dao2.deleteAll(list2);

				}

			}
		}

		return new Gourmet_map_Response(RtnCode.SUCCESSFUL.getMessage());
	}

}
