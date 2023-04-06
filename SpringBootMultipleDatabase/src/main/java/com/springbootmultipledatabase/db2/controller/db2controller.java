package com.springbootmultipledatabase.db2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmultipledatabase.db2.beans.Productdb2bean;
import com.springbootmultipledatabase.db2.service.db2service;

@RestController
@RequestMapping("/req")
public class db2controller {
	
	@Autowired
	private db2service db2;
	
	@PostMapping("/posxml")
	public Productdb2bean addprod(@RequestBody Productdb2bean productdb2bean)
	{
		return db2.saveprod(productdb2bean);
	}

}
