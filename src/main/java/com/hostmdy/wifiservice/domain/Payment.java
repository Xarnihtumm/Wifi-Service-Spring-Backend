package com.hostmdy.wifiservice.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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


	@NotNull(message = "Pay For Your Fee")
	private Integer totalPrices;

	private LocalDate date;
	
	
	@OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
	
	
	@PrePersist
	void OnCreate() {
		this.date = LocalDate.now();
	}
	
	@PreUpdate
	void OnUpdate() {
		this.date = LocalDate.now();
	}

	public Payment(Long paymentId, @NotNull(message = "Pay For Your Fee") Integer totalPrices, LocalDate date,
			Order order) {
		super();
		this.paymentId = paymentId;
		this.totalPrices = totalPrices;
		this.date = date;
		this.order = order;
	}

	

	

}
