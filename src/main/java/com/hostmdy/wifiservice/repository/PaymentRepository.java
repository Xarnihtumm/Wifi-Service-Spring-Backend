package com.hostmdy.wifiservice.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.wifiservice.domain.Payment;

public interface PaymentRepository  extends CrudRepository<Payment, Long>{
	
	
	
	Optional<Payment> findByDate(LocalDate date);
	Optional<Payment> findByPaymentId(Long paymentId);

	
	

}
