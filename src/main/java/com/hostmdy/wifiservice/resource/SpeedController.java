package com.hostmdy.wifiservice.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.wifiservice.domain.Speed;
import com.hostmdy.wifiservice.service.SpeedService;
import com.hostmdy.wifiservice.service.ValidationErrorsMapService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/speed")
public class SpeedController {
	
	private final SpeedService speedService;
	private final ValidationErrorsMapService errorMapService;
	
	@Autowired
	public SpeedController(SpeedService speedService, ValidationErrorsMapService errorMapService) {
		super();
		this.speedService = speedService;
		this.errorMapService = errorMapService;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createSpeed(@Valid @RequestBody Speed speed, BindingResult result) {
		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);
		if (responseErrorObject != null)
			return responseErrorObject;
System.out.println("Hahah");
		Speed createSpeed = speedService.createSpeed(speed);
		return new ResponseEntity<Speed>(createSpeed, HttpStatus.CREATED);
	}
	
//	@PostMapping("/update")
//	public ResponseEntity<?> updateSpeed(@Valid @RequestBody Speed speed, BindingResult result) {
//		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);
//		if (responseErrorObject != null)
//			return responseErrorObject;
//
//		WifiPlan updateWifiPlan = speedService.updateWifiPlan(wifiPlan);
//		return new ResponseEntity<WifiPlan>(updateWifiPlan, HttpStatus.CREATED);
//	}
	
	@GetMapping("/all")
	public List<Speed> findAllPlan() {
		return speedService.findAll();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Speed> speedOptional = speedService.findById(id);

		if (speedOptional.isEmpty())
			return new ResponseEntity<String>("Plans with id = " + id + " not found", HttpStatus.NOT_FOUND);

		return new ResponseEntity<Speed>(speedOptional.get(), HttpStatus.OK);
	}
	
//	@GetMapping("/name/{MB}")
//	public ResponseEntity<?> findByName(@PathVariable Integer MB) {
//		
//		
//		Optional<Speed> speedOptional = speedService.findByMB(MB);
//
//		if (speedOptional.isEmpty())
//			return new ResponseEntity<String>("Plans with Name = " + MB + " not found", HttpStatus.NOT_FOUND);
//
//		return new ResponseEntity<Speed>(speedOptional.get(), HttpStatus.OK);
//	}
	

	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		
		Optional<Speed> speedOptional = speedService.findById(id);

		if (speedOptional.isEmpty())
			return new ResponseEntity<String>("PLans with id = " + id+ " not found", HttpStatus.NOT_FOUND);

		speedService.deleteById(id);

		return new ResponseEntity<String>("Plans with id = " + id + " is deleted", HttpStatus.OK);
	}
	@DeleteMapping("/all")
	public  ResponseEntity<String> deleteAll(Speed speed) {
		
		List <Speed> speedOptional = speedService.findAll();

		if (speedOptional.isEmpty())
			return new ResponseEntity<String>("No Plans To Delete", HttpStatus.NOT_FOUND);

		speedService.DeleteAll(speed);
		return new ResponseEntity<String>("All Plans Successfully Deleted", HttpStatus.OK);

		
	}
	
	

}
