package com.hostmdy.wifiservice.resource;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.wifiservice.domain.Order;
import com.hostmdy.wifiservice.domain.User;
import com.hostmdy.wifiservice.domain.WifiPlan;
import com.hostmdy.wifiservice.domain.WifiUser;
import com.hostmdy.wifiservice.repository.UserRepository;
import com.hostmdy.wifiservice.repository.WifiPlanRepository;
import com.hostmdy.wifiservice.repository.WifiUserRepository;
import com.hostmdy.wifiservice.service.OrderService;
import com.hostmdy.wifiservice.service.ValidationErrorsMapService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins ="http://localhost:3000")
public class OrderController {

	private final OrderService orderService;
	private final UserRepository userRepository;
	private final WifiUserRepository wifiUserRepository;
	private final WifiPlanRepository wifiPlanRepository;
	private final ValidationErrorsMapService errorMapService;

	@Autowired
	public OrderController(OrderService orderService, UserRepository userRepository,
			WifiUserRepository wifiUserRepository, WifiPlanRepository wifiPlanRepository,
			ValidationErrorsMapService errorMapService) {
		super();
		this.orderService = orderService;
		this.userRepository = userRepository;
		this.wifiUserRepository = wifiUserRepository;
		this.wifiPlanRepository = wifiPlanRepository;
		this.errorMapService = errorMapService;
	}

	

//	@PostMapping("/create/user/{id}/{planId}/{deviceId}"
	@PostMapping("/create/{planId}/{deviceId}")
	public ResponseEntity<?> createOrder(/*{@PathVariable Long id,} */@PathVariable Long planId, @PathVariable Long deviceId, @Valid @RequestBody Order order, BindingResult result,Principal principal) {
		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);
		if (responseErrorObject != null)
			return responseErrorObject;

//		User user = userRepository.findById(id).orElse(null);
//		if (user == null)
//			return new ResponseEntity<String>("User with id = " + id + " not found", HttpStatus.NOT_FOUND);
		User user= userRepository.findByUsername(principal.getName()).get();
		
	if(user.getRole().equals("low")) {
		if (user == null)
		return new ResponseEntity<String>("Device with id = " + user + " not found", HttpStatus.NOT_FOUND);

		WifiPlan plan = wifiPlanRepository.findById(planId).orElse(null);
		if (plan == null)
			return new ResponseEntity<String>("Plan with id = " + planId + " not found", HttpStatus.NOT_FOUND);

		//order.setDevice(device);
		order.setPlan(plan);
		order.setUser(user);
		//device.setOrder(order); // Set the order on the device
		user.getOrders().add(order);
	}
	
	if(user.getRole().equals("user")) {
		WifiUser device = wifiUserRepository.findById(deviceId).orElse(null);
		if (device == null)
			return new ResponseEntity<String>("Device with id = " + deviceId + " not found", HttpStatus.NOT_FOUND);

		WifiPlan plan = wifiPlanRepository.findById(planId).orElse(null);
		if (plan == null)
			return new ResponseEntity<String>("Plan with id = " + planId + " not found", HttpStatus.NOT_FOUND);

		order.setDevice(device);
		order.setPlan(plan);
		//order.setUser(user);
		device.setOrder(order); // Set the order on the device
		//user.getOrders().add(order);
	}
	
		Order createdOrder = orderService.createOrder(order);
		return new ResponseEntity<Order>(createdOrder, HttpStatus.CREATED);
	}
	
	
	
	@PostMapping("/{orderId}/status")
	public ResponseEntity<?> updateOrderStatus(@PathVariable Long orderId, @RequestParam("status") String status) {
	    Optional<Order> orderOptional = orderService.findByOrderId(orderId);

	    if (orderOptional.isEmpty()) {
	        return new ResponseEntity<String>("Order with id = " + orderId + " not found", HttpStatus.NOT_FOUND);
	    }

	    Order order = orderOptional.get();
	    order.setOrderStatus(status);
//
//	    if (status.equalsIgnoreCase("Success")) {
//	        // Create the payment table logic here
//	        // ...
//
//	        // Assuming the payment table creation is successful
//	        return new ResponseEntity<String>("Order status updated to Success. Payment table created.", HttpStatus.OK);
//	    }

	    // Save the updated order
	    Order updatedOrder = orderService.createOrder(order);
	    return new ResponseEntity<Order>(updatedOrder, HttpStatus.OK);
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
