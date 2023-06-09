package com.hostmdy.wifiservice.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="orders")
@NoArgsConstructor
public class Order {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   	private Long orderId;
    
  
   	private LocalDate date;
    
    @NotNull(message="Pay for your fee")
	private Double serviceFee;
    
  
	
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
	
	
	
	

	public Order(@NotNull(message = "Fill Id")  Long orderId, @NotNull(message = "Pay for your fee") Double serviceFee,
			@NotBlank(message = "Date is invalid") LocalDate date) {
		super();
		this.orderId = orderId;
		this.serviceFee = serviceFee;
		this.date = date;
	}

	@PrePersist
	void OnCreate() {
		this.date = LocalDate.now();
	}
	
	@PreUpdate
	void OnUpdate() {
		this.date = LocalDate.now();
	}
}
