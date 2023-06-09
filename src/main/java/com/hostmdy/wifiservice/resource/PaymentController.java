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

import com.hostmdy.wifiservice.domain.Payment;
import com.hostmdy.wifiservice.service.PaymentService;
import com.hostmdy.wifiservice.service.ValidationErrorsMapService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/payment")
public class PaymentController {
	
	
	private final PaymentService paymentService;
	private final ValidationErrorsMapService errorMapService;
	
	
	@Autowired
	public PaymentController(PaymentService paymentService, ValidationErrorsMapService errorMapService) {
		super();
		this.paymentService = paymentService;
		this.errorMapService = errorMapService;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<?> createPayment(@Valid @RequestBody Payment payment, BindingResult result) {
		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);
		if (responseErrorObject != null)
			return responseErrorObject;

		Payment createPayment = paymentService.createOrder(payment);
		return new ResponseEntity<Payment>(createPayment, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Payment> findAllPayment() {
		return paymentService.findAllPayment();
	}

	@GetMapping("/id/{paymentId}")
	public ResponseEntity<?> findById(@PathVariable Long paymentId) {
		Optional<Payment> paymentOptional = paymentService.findByPaymentId(paymentId);

		if (paymentOptional.isEmpty())
			return new ResponseEntity<String>("Payment with id = " + paymentId + " not found", HttpStatus.NOT_FOUND);

		return new ResponseEntity<Payment>(paymentOptional.get(), HttpStatus.OK);
	}

	@DeleteMapping("/id/{paymentId}")
	public ResponseEntity<String> deleteById(@PathVariable Long paymentId) {
		
		Optional<Payment> paymentOptional = paymentService.findByPaymentId(paymentId);

		if (paymentOptional.isEmpty())
			return new ResponseEntity<String>("Order with id = " + paymentId+ " not found", HttpStatus.NOT_FOUND);

		paymentService.deleteById(paymentId);

		return new ResponseEntity<String>("Order with id = " + paymentId + " is deleted", HttpStatus.OK);
	}
	@DeleteMapping("/all")
	public  ResponseEntity<String> deleteAll(Payment payment) {
		
		List <Payment> paymentOptional = paymentService.findAllPayment();

		if (paymentOptional.isEmpty())
			return new ResponseEntity<String>("No Payments To Delete", HttpStatus.NOT_FOUND);

		paymentService.deleteAll(payment);
		return new ResponseEntity<String>("All Payment Successfully Deleted", HttpStatus.OK);

		
	}
	
	
	
	

}
