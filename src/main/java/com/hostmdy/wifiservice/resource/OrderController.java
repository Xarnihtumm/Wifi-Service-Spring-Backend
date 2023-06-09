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

import com.hostmdy.wifiservice.domain.Order;
import com.hostmdy.wifiservice.domain.User;
import com.hostmdy.wifiservice.repository.UserRepository;
import com.hostmdy.wifiservice.service.OrderService;
import com.hostmdy.wifiservice.service.ValidationErrorsMapService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	private final OrderService orderService;
	private final UserRepository userRepository;
	private final ValidationErrorsMapService errorMapService;

	
	
	

	
	@Autowired
	public OrderController(OrderService orderService, UserRepository userRepository,
			ValidationErrorsMapService errorMapService) {
		super();
		this.orderService = orderService;
		this.userRepository = userRepository;
		this.errorMapService = errorMapService;
	}

	@PostMapping("user/{id}/create")
	public ResponseEntity<?> createOrder(@PathVariable Long id,@Valid @RequestBody Order order, BindingResult result) {
		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);
		if (responseErrorObject != null)
			return responseErrorObject;
		User user = userRepository.findById(id).get();

		order.setUser(user);
		user.getOrders().add(order);
		//user.getAppointment().add(appointment);

		Order createOrder = orderService.createOrder(order);
		return new ResponseEntity<Order> (createOrder, HttpStatus.CREATED);
	}



	@GetMapping("/all")
	public List<Order> findAllOrder() {
		return orderService.findAllOrder();
	}

	@GetMapping("/id/{orderId}")
	public ResponseEntity<?> findById(@PathVariable Long orderId) {
		Optional<Order> orderOptional = orderService.findByOrderId(orderId);

		if (orderOptional.isEmpty())
			return new ResponseEntity<String>("Order with id = " + orderId + " not found", HttpStatus.NOT_FOUND);

		return new ResponseEntity<Order>(orderOptional.get(), HttpStatus.OK);
	}

	@DeleteMapping("/id/{orderId}")
	public ResponseEntity<String> deleteById(@PathVariable Long orderId) {

		Optional<Order> orderOptional = orderService.findByOrderId(orderId);

		if (orderOptional.isEmpty())
			return new ResponseEntity<String>("Order with id = " + orderId + " not found", HttpStatus.NOT_FOUND);

		orderService.deleteById(orderId);

		return new ResponseEntity<String>("Order with id = " + orderId + " is deleted", HttpStatus.OK);
	}

	@DeleteMapping("/all")
	public ResponseEntity<String> deleteAll(Order order) {

		List<Order> orderOptional = orderService.findAllOrder();

		if (orderOptional.isEmpty())
			return new ResponseEntity<String>("No orders To Delete", HttpStatus.NOT_FOUND);

		orderService.deleteAll(order);
		return new ResponseEntity<String>("All Order Successfully Deleted", HttpStatus.OK);

	}

}
