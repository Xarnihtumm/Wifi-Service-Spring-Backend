
package com.hostmdy.wifiservice.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.wifiservice.payload.JwtLoginSuccessResponse;
import com.hostmdy.wifiservice.payload.LoginRequest;
import com.hostmdy.wifiservice.security.JwtTokenProvider;
import com.hostmdy.wifiservice.validator.UserValidator;
import com.hostmdy.wifiservice.domain.User;
import com.hostmdy.wifiservice.service.UserService;
import com.hostmdy.wifiservice.service.ValidationErrorsMapService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	private static final String TOKEN_PREFIX = "Bearer ";

	private final UserService userService;
	private final ValidationErrorsMapService errorMapService;
	private final UserValidator userValidator;
	private final JwtTokenProvider tokenProvider;
	private final AuthenticationManager authenticationManager;

	@Autowired
	public UserController(UserService userService, ValidationErrorsMapService errorMapService,
			UserValidator userValidator, JwtTokenProvider tokenProvider, AuthenticationManager authenticationManager) {
		super();
		this.userService = userService;
		this.errorMapService = errorMapService;
		this.userValidator = userValidator;
		this.tokenProvider = tokenProvider;
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {

		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);
		Optional<User> user = userService.findByUserName(loginRequest.getUsername());
		if (responseErrorObject != null)
			return responseErrorObject;

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);

		return ResponseEntity.ok(new JwtLoginSuccessResponse(true, jwt, user.get()));

	}

	@PostMapping("/create")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result) {
		userValidator.validate(user, result);
		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);
		if (responseErrorObject != null)
			return responseErrorObject;

		User createUser = userService.createUser(user);
		return new ResponseEntity<User>(createUser, HttpStatus.CREATED);

	}

	@GetMapping("/all")
	public List<User> findAllUser() {
		return userService.findAll();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<User> userOptional = userService.findById(id);

		if (userOptional.isEmpty())
			return new ResponseEntity<String>("User with id = " + id + " not found", HttpStatus.NOT_FOUND);

		return new ResponseEntity<User>(userOptional.get(), HttpStatus.OK);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {

		Optional<User> userOptional = userService.findById(id);

		if (userOptional.isEmpty())
			return new ResponseEntity<String>("User with id = " + id + " not found", HttpStatus.NOT_FOUND);

		userService.deleteById(id);

		return new ResponseEntity<String>("User with id = " + id + " is deleted", HttpStatus.OK);
	}

	@DeleteMapping("/all")
	public ResponseEntity<String> deleteAll(User user) {

		List<User> userOptional = userService.findAll();

		if (userOptional.isEmpty())
			return new ResponseEntity<String>("No Users To Delete", HttpStatus.NOT_FOUND);

		userService.DeleteAll(user);
		return new ResponseEntity<String>("All User Successfully Deleted", HttpStatus.OK);

	}
}
