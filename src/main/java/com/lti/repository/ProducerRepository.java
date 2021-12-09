package com.lti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.lti.model.Customer;
@Repository
@EnableJpaRepositories
public interface ProducerRepository extends JpaRepository<Customer, Integer>{
	
	Customer findByName(String name);

}
