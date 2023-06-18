package com.hostmdy.wifiservice.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.wifiservice.domain.Discount;
import com.hostmdy.wifiservice.domain.Speed;
import com.hostmdy.wifiservice.repository.SpeedRepository;
import com.hostmdy.wifiservice.service.DiscountService;
import com.hostmdy.wifiservice.service.ValidationErrorsMapService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/discount")
@CrossOrigin(origins ="http://localhost:3000")
public class DiscountController {
	
	
	private final DiscountService discountService;
	private final ValidationErrorsMapService errorMapService;
	private final SpeedRepository speedRepository;
	
	
	
	
	
	@Autowired
	public DiscountController(DiscountService discountService, ValidationErrorsMapService errorMapService,
			SpeedRepository speedRepository) {
		super();
		this.discountService = discountService;
		this.errorMapService = errorMapService;
		this.speedRepository = speedRepository;
	}

	@PostMapping("speed/{id}/create")
	public ResponseEntity<?> createDiscount( @PathVariable Long id,@Valid @RequestBody Discount discount, BindingResult result) {
		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);
		if (responseErrorObject != null)
			return responseErrorObject;
		
		Speed speed = speedRepository.findById(id).get();
		
		discount.setSpeed(speed);
		speed.getDiscount().add(discount);
//		order.setUser(user);
//		user.getOrders().add(order);
		
		Discount createDiscount = discountService.createDiscount(discount);
		return new ResponseEntity<Discount>(createDiscount, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Discount> findAll() {
		
		return discountService.findAll();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Discount> discountOptional = discountService.findById(id);

		if (discountOptional.isEmpty())
			return new ResponseEntity<String>("Plans with id = " + id + " not found", HttpStatus.NOT_FOUND);

		return new ResponseEntity<Discount>(discountOptional.get(), HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name) {
		
		
		Optional<Discount> discountOptional = discountService.findByName(name);

		if (discountOptional.isEmpty())
			return new ResponseEntity<String>("Plans with Name = " + name + " not found", HttpStatus.NOT_FOUND);

		return new ResponseEntity<Discount>(discountOptional.get(), HttpStatus.OK);
	}
	

	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		
		Optional<Discount> discountOptional = discountService.findById(id);
		

		if (discountOptional.isEmpty())
			return new ResponseEntity<String>("PLans with id = " + id+ " not found", HttpStatus.NOT_FOUND);

		 discountService.deleteById(id);
		return new ResponseEntity<String>("Plans with id = " + id + " is deleted", HttpStatus.OK);
	}
	@DeleteMapping("/all")
	public  ResponseEntity<String> deleteAll(Discount discount) {
		
		List <Discount> discountOptional =discountService.findAll();

		if (discountOptional.isEmpty())
			return new ResponseEntity<String>("No Plans To Delete", HttpStatus.NOT_FOUND);

		discountService.DeleteAll(discount);
		return new ResponseEntity<String>("All Plans Successfully Deleted", HttpStatus.OK);

		
	}
	

}
