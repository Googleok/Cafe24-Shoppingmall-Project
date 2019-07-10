package com.cafe24.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.repository.AdminDao;

@Service
public class AdminService {

	
	@Autowired
	private AdminDao adminDao;
}
