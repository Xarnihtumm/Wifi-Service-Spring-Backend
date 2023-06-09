package com.hostmdy.wifiservice.resource;

import java.util.List;
import java.util.Optional;

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

import com.hostmdy.wifiservice.domain.WifiUser;
import com.hostmdy.wifiservice.service.ValidationErrorsMapService;
import com.hostmdy.wifiservice.service.WifiUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/devices")
public class WifiUserController {
	
	
	private final WifiUserService wifiUserService;
	private final ValidationErrorsMapService errorMapService;
	
	
	public WifiUserController(WifiUserService wifiUserService, ValidationErrorsMapService errorMapService) {
		super();
		this.wifiUserService = wifiUserService;
		this.errorMapService = errorMapService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createPayment(@Valid @RequestBody WifiUser wifiUser, BindingResult result) {
		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);
		if (responseErrorObject != null)
			return responseErrorObject;

		WifiUser createWifiUser = wifiUserService.createWifiUser(wifiUser);
		return new ResponseEntity<WifiUser>(createWifiUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<WifiUser> findAllWifiUser() {
		return wifiUserService.findAllPayment();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<WifiUser> paymentOptional = wifiUserService.findById(id);

		if (paymentOptional.isEmpty())
			return new ResponseEntity<String>("Devices with id = " + id + " not found", HttpStatus.NOT_FOUND);

		return new ResponseEntity<WifiUser>(paymentOptional.get(), HttpStatus.OK);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		
		Optional<WifiUser> paymentOptional = wifiUserService.findById(id);

		if (paymentOptional.isEmpty())
			return new ResponseEntity<String>("Device with id = " + id+ " not found", HttpStatus.NOT_FOUND);

		wifiUserService.deleteById(id);

		return new ResponseEntity<String>("Deviec with id = " + id + " is deleted", HttpStatus.OK);
	}
	@DeleteMapping("/all")
	public  ResponseEntity<String> deleteAll(WifiUser wifiUser) {
		
		List <WifiUser> paymentOptional = wifiUserService.findAllPayment();

		if (paymentOptional.isEmpty())
			return new ResponseEntity<String>("No Devices To Delete", HttpStatus.NOT_FOUND);

		wifiUserService.deleteAll(wifiUser);
		return new ResponseEntity<String>("All Devicies Successfully Deleted", HttpStatus.OK);

		
	}
	
	

}
