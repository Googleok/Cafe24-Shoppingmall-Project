package com.cafe24.shoppingmall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.AdminDao;
import com.cafe24.shoppingmall.vo.ProductVo;

@Service
public class AdminService {

	
	@Autowired
	private AdminDao adminDao;

	public List<ProductVo> getProductList() {
		List<ProductVo> list = new ArrayList<ProductVo>();
		list.add(new ProductVo(1L, "모자", 30000L, "2019-07-11", true,
			false, true, 1L, 400L, "cap.html",
			2500L, 3L));
		return list;
	}

	public ProductVo getProductOne(Long no) {
		ProductVo vo = new ProductVo(1L, "모자", 30000L, "2019-07-11", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		return vo;
	}

	public Boolean addProduct(ProductVo vo) {
		return vo != null;
	}

	public ProductVo modifyProduct(Long no, ProductVo newVo) {
		ProductVo resultVo = null;
		
		ProductVo vo1 = new ProductVo(1L, "모자", 30000L, "2019-07-11", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo2 = new ProductVo(2L, "모자", 30000L, "2019-07-12", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo3 = new ProductVo(3L, "모자", 30000L, "2019-07-13", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNo() == no) {
				list.get(i).setName(newVo.getName());
				list.get(i).setPrice(newVo.getPrice());
				resultVo = list.get(i);
			}
		}
		
		return resultVo;
	}

	public boolean deleteProduct(Long no) {
		ProductVo vo1 = new ProductVo(1L, "모자", 30000L, "2019-07-11", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo2 = new ProductVo(2L, "모자", 30000L, "2019-07-12", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		ProductVo vo3 = new ProductVo(3L, "모자", 30000L, "2019-07-13", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L); 
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		int listSize1 = list.size();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNo() == no) {
				list.remove(i);
			}
		}
		int listSize2 = list.size();
		System.out.println(list);
		return listSize1 == listSize2+1;
	}
	
}
