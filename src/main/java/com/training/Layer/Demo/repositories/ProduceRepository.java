package com.training.Layer.Demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.Layer.Demo.entities.Produce;

@Repository
public interface ProduceRepository extends JpaRepository<Produce, Long> {
	
	
	

}
