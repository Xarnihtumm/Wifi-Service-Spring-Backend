package com.hostmdy.wifiservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hostmdy.wifiservice.domain.Payment;



public interface PaymentService {
	
	List<Payment> findAllPayment();
	Optional<Payment> findByPaymentId(Long paymentId);
	Optional<Payment>  findByDate(LocalDate date);
	
	void deleteById(Long paymentId);
	void deleteAll(Payment payment);
	
	Payment saveOrUpdate(Payment payment);
	Payment createOrder(Payment payment);

}
