package com.springbootmultipledatabase.db2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootmultipledatabase.db2.beans.Productdb2bean;
import com.springbootmultipledatabase.db2.repo.Productdb2repo;
@Service
public class db2service {
	@Autowired
	private Productdb2repo productdb2repo;
	
	
	public Productdb2bean saveprod(Productdb2bean productdb2bean)
	{
		return productdb2repo.save(productdb2bean);
	}

}
