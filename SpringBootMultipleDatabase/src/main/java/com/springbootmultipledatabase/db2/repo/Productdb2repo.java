package com.springbootmultipledatabase.db2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootmultipledatabase.db2.beans.Productdb2bean;
@Repository
public interface Productdb2repo extends JpaRepository<Productdb2bean, Integer>{

}
