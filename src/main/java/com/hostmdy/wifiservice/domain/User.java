//package com.hostmdy.wifiservice.domain;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;
//
//@NoArgsConstructor
//@Entity
//@Data
//@Table(name="User")
//public class User {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long Id;
//
//	@NotBlank(message = "Fill Your Name")
//	private String name;
//
//	@NotBlank(message = "Fill your email")
//	private String email;
//
//	@NotBlank(message = "Fill Your Phone No")
//	private String phNo;
//
//	@NotBlank(message = "Fill Your Password")
//	private String password;
//	
//	@NotBlank(message="Create YOur role")
//	private String role;
//
//	public User(Long id, @NotBlank(message = "Fill Your Name") String name,
//			@NotBlank(message = "Fill your email") String email, @NotBlank(message = "Fill Your Phone No") String phNo,
//			@NotBlank(message = "Fill Your Password") String password,
//			@NotBlank(message = "Create YOur role") String role) {
//		super();
//		Id = id;
//		this.name = name;
//		this.email = email;
//		this.phNo = phNo;
//		this.password = password;
//		this.role = role;
//	}
//	
//	
//	
//	
//
//}

package com.hostmdy.wifiservice.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Please provide your name")
	private String name;

	@NotBlank(message = "Please provide your email")
	@Email(message = "You must to fill  your email")
	private String username;

	@NotBlank(message = "Please provide your phone number")
	private String phoneNumber;

	@NotBlank(message = "Please provide your password")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@Transient
	private String confirmPassword;

	@NotNull(message = "No Acess Your Location")
	private Double longitude;

	@NotNull(message = "No Access Your Location")
	private Double latitude;
	
	@NotBlank(message = "Please provide a role")
	private String role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Order> orders = new ArrayList<>();

	
	public User(Long id, @NotBlank(message = "Please provide your name") String name,
			@NotBlank(message = "Please provide your email") @Email(message = "You must to fill  your email") String username,
			@NotBlank(message = "Please provide your phone number") String phoneNumber,
			@NotBlank(message = "Please provide your password") String password, String confirmPassword,
			@NotNull(message = "No Acess Your Location") Double longitude,
			@NotNull(message = "No Access Your Location") Double latitude,
			@NotBlank(message = "Please provide a role") String role, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.longitude = longitude;
		this.latitude = latitude;
		this.role = role;
		this.orders = orders;
	}
	
	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
