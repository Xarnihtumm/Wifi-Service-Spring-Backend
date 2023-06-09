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
import java.util.List;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please provide your name")
    private String name;

    @NotBlank(message = "Please provide your email")
    @Email(message="You must to fill  your email")
    private String email;

    @NotBlank(message = "Please provide your phone number")
    private String phoneNumber;

    @NotBlank(message = "Please provide your password")
    private String password;

    @NotBlank(message = "Please provide a role")
    private String role;
    
    
    
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    
    private List<Order> orders = new ArrayList<>();

    public User(String name, String email, String phoneNumber, String password, String role) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }
}

