package com.springbootmultipledatabase.db1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootmultipledatabase.db1.beans.Productdb1bean;
@Repository
public interface Productdb1repo extends JpaRepository<Productdb1bean, Integer>{

}
