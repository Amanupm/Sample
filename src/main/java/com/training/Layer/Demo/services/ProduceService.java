package com.training.Layer.Demo.services;

import java.util.List;
import java.util.Optional;

import com.training.Layer.Demo.entities.Produce;

public interface ProduceService {

	 public void delete(Long id);
	 
	 public Produce updateProduce (Produce product);
	 
	 public Produce createProduct(Produce product);
	 
	 public List <Produce> getAllProduce();

	public Optional<Produce> getProduceById(Long id);

	
}