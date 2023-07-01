package com.hostmdy.wifiservice.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	private String accountName;

	private Long transactionNo;
	
	private Integer mb;
	
	private Integer months;
	

	@NotNull(message = "Pay For Your Fee")
	private Double total;

	private LocalDate date;

	private String orderStatus;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "device_id")
	//@JsonIgnore
	private WifiUser device;

//	@OneToOne(mappedBy = "order", fetch = FetchType.LAZY)
//	@JsonIgnore
//	private WifiUser device;

	@OneToOne
	@JoinColumn(name = "plan_id")

	private WifiPlan plan;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	@OneToOne(mappedBy = "order")
	
	private Payment payment;

	@PrePersist
	void OnCreate() {
		this.date = LocalDate.now();
	}

	@PreUpdate
	void OnUpdate() {
		this.date = LocalDate.now();
	}

	public Order(Long orderId, String accountName, Long transactionNo, Integer mb, Integer months,
			@NotNull(message = "Pay For Your Fee") Double total, LocalDate date, String orderStatus, WifiUser device,
			WifiPlan plan, User user, Payment payment) {
		super();
		this.orderId = orderId;
		this.accountName = accountName;
		this.transactionNo = transactionNo;
		this.mb = mb;
		this.months = months;
		this.total = total;
		this.date = date;
		this.orderStatus = orderStatus;
		this.device = device;
		this.plan = plan;
		this.user = user;
		this.payment = payment;
	}

	

}
