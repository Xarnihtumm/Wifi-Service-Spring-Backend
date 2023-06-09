package com.hostmdy.wifiservice.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;

	@NotNull(message = "Jesus")
	private Boolean status;

	@NotNull(message = "Pay For Your Fee")
	private Double prices;

	private LocalDate date;
	
	

	public Payment(Long paymentId, @NotNull(message = "Jesus") Boolean status,
			@NotNull(message = "Pay For Your Fee") Double prices, LocalDate date) {
		super();
		this.paymentId = paymentId;
		this.status = status;
		this.prices = prices;
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
