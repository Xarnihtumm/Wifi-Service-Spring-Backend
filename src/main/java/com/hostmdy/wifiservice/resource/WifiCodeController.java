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

import com.hostmdy.wifiservice.domain.WifiCode;
import com.hostmdy.wifiservice.domain.WifiPlan;
import com.hostmdy.wifiservice.repository.WifiCodeRepository;
import com.hostmdy.wifiservice.service.ValidationErrorsMapService;
import com.hostmdy.wifiservice.service.WificodeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/wificode")
@CrossOrigin(origins ="http://localhost:3000")
public class WifiCodeController {
	
	
	
	private final WificodeService wificodeService;
	private final ValidationErrorsMapService errorMapService;
	
	
	
	
	
	@Autowired
	public WifiCodeController(WificodeService wificodeService, ValidationErrorsMapService errorMapService) {
		super();
		this.wificodeService = wificodeService;
		this.errorMapService = errorMapService;
		
	}
	
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createWificode(@Valid @RequestBody WifiCode wifiCode, BindingResult result) {
		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);
		if (responseErrorObject != null)
			return responseErrorObject;

		WifiCode createWifiCode = wificodeService.saveOrUpdateWifiCode(wifiCode);
		return new ResponseEntity<WifiCode>(createWifiCode, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/all")
	public List<WifiCode> findAllCode() {
		return wificodeService.findAll();
	}

	

	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		
		Optional<WifiCode> paymentOptional = wificodeService.findById(id);

		if (paymentOptional.isEmpty())
			return new ResponseEntity<String>("PLans with id = " + id+ " not found", HttpStatus.NOT_FOUND);

		wificodeService.deleteById(id);

		return new ResponseEntity<String>("Code with id = " + id + " is deleted", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	

}
