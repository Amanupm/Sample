package com.training.Layer.Demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.Layer.Demo.entities.Produce;
import com.training.Layer.Demo.exceptions.ProduceNotFoundException;
import com.training.Layer.Demo.services.ProduceService;

@RestController
@RequestMapping("/api/v2")
public class ProduceController  {
	
	@Autowired
	ProduceService produceService;
	
	 @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	   public ResponseEntity<Object> getById(@PathVariable("id") Long id) { 
		Optional<Produce> product = produceService.getProduceById(id);
		if(product.isEmpty()) throw new ProduceNotFoundException();
	      return new ResponseEntity<>(product, HttpStatus.OK);
	   }
	
	 @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> delete(@PathVariable("id") Long id) { 
		 produceService.delete(id);
	      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Object> updateProduct(@RequestBody Produce product) { 
	      produceService.createProduct(product);
	      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/products", method = RequestMethod.POST)
	   public ResponseEntity<Object> createProduct(@RequestBody Produce product) {
		   produceService.createProduct(product);
	      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	   }

	   @RequestMapping(value = "/products")
	   public ResponseEntity<Object> getAllProduct() {
	      return new ResponseEntity<>(produceService.getAllProduce(), HttpStatus.OK);
	   }
}
