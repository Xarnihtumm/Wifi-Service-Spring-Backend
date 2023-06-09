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

import com.hostmdy.wifiservice.domain.WifiPlan;
import com.hostmdy.wifiservice.service.ValidationErrorsMapService;
import com.hostmdy.wifiservice.service.WifiPlanService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/plans")
@CrossOrigin(origins ="http://localhost:3000")
public class WifiPlanController {
	
	
	private final WifiPlanService wifiPlanService;
	private final ValidationErrorsMapService errorMapService;
	
	@Autowired
	public WifiPlanController(WifiPlanService wifiPlanService, ValidationErrorsMapService errorMapService) {
		super();
		this.wifiPlanService = wifiPlanService;
		this.errorMapService = errorMapService;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createWifiPlan(@Valid @RequestBody WifiPlan wifiPlan, BindingResult result) {
		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);
		if (responseErrorObject != null)
			return responseErrorObject;

		WifiPlan createWifiPlan = wifiPlanService.createWifiPlan(wifiPlan);
		return new ResponseEntity<WifiPlan>(createWifiPlan, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updatePayment(@Valid @RequestBody WifiPlan wifiPlan, BindingResult result) {
		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);
		if (responseErrorObject != null)
			return responseErrorObject;

		WifiPlan updateWifiPlan = wifiPlanService.updateWifiPlan(wifiPlan);
		return new ResponseEntity<WifiPlan>(updateWifiPlan, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<WifiPlan> findAllPlan() {
		return wifiPlanService.findAllPlan();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<WifiPlan> paymentOptional = wifiPlanService.findById(id);

		if (paymentOptional.isEmpty())
			return new ResponseEntity<String>("Plans with id = " + id + " not found", HttpStatus.NOT_FOUND);

		return new ResponseEntity<WifiPlan>(paymentOptional.get(), HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name) {
		
		
		Optional<WifiPlan> paymentOptional = wifiPlanService.findByplanName(name);

		if (paymentOptional.isEmpty())
			return new ResponseEntity<String>("Plans with Name = " + name + " not found", HttpStatus.NOT_FOUND);

		return new ResponseEntity<WifiPlan>(paymentOptional.get(), HttpStatus.OK);
	}
	

	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		
		Optional<WifiPlan> paymentOptional = wifiPlanService.findById(id);

		if (paymentOptional.isEmpty())
			return new ResponseEntity<String>("PLans with id = " + id+ " not found", HttpStatus.NOT_FOUND);

		wifiPlanService.deleteById(id);

		return new ResponseEntity<String>("Plans with id = " + id + " is deleted", HttpStatus.OK);
	}
	@DeleteMapping("/all")
	public  ResponseEntity<String> deleteAll(WifiPlan wifiPlan) {
		
		List <WifiPlan> paymentOptional = wifiPlanService.findAllPlan();

		if (paymentOptional.isEmpty())
			return new ResponseEntity<String>("No Plans To Delete", HttpStatus.NOT_FOUND);

		wifiPlanService.deleteAll(wifiPlan);
		return new ResponseEntity<String>("All Plans Successfully Deleted", HttpStatus.OK);

		
	}
	
	
	
	
	
	
	

}
