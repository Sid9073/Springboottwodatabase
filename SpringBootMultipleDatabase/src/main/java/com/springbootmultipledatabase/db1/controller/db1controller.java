package com.springbootmultipledatabase.db1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmultipledatabase.db1.beans.Productdb1bean;
import com.springbootmultipledatabase.db1.service.db1service;

@RestController
@RequestMapping("/req")
public class db1controller {
	@Autowired
	private db1service db1;
	
	@PostMapping("/postmap")
	public Productdb1bean addprod(@RequestBody Productdb1bean productdb1bean)
	{
		return db1.saveprod(productdb1bean);
	}
	

}
