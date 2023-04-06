package com.springbootmultipledatabase.db1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootmultipledatabase.db1.beans.Productdb1bean;
import com.springbootmultipledatabase.db1.repo.Productdb1repo;
@Service
public class db1service {
	@Autowired
	private Productdb1repo productdb1repo;
	
	
	public Productdb1bean saveprod(Productdb1bean productdb1bean)
	{
		return productdb1repo.save(productdb1bean);
	}

}
