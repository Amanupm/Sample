package com.training.Layer.Demo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.Layer.Demo.entities.Produce;
import com.training.Layer.Demo.repositories.ProduceRepository;


@Service
public class ProduceServiceImpl  implements ProduceService {
	@Autowired
	ProduceRepository produceRepository ;
	
	
	 
	   public void delete(Long id) { 
		   produceRepository.deleteById(id);
	     
	   }
	   
	   
	   public Produce updateProduce (Produce product) { 
		   return produceRepository.save(product);
	     
	   }
	   
	  
	   public Produce createProduct(Produce product) {
		   return produceRepository.save(product);
	      
	   }
	   
	   public Optional<Produce> getProduceById(Long id) {
		   return produceRepository.findById(id);
		   
		      
	   }
	   
	   public List <Produce> getAllProduce() {
		   return produceRepository.findAll();
		   
	      
	   }
	
	
	

}
