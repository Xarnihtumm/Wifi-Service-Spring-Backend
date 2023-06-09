package com.hostmdy.wifiservice.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.wifiservice.domain.Payment;
import com.hostmdy.wifiservice.repository.PaymentRepository;
import com.hostmdy.wifiservice.service.PaymentService;


@Service
public class PaymentServiceImpl  implements PaymentService{
	
	private final PaymentRepository paymentRepository;
	
	

	@Autowired
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		super();
		this.paymentRepository = paymentRepository;
	}

	@Override
	public List<Payment> findAllPayment() {
		// TODO Auto-generated method stub
		return (List<Payment>) paymentRepository.findAll();
	}

	@Override
	public Optional<Payment> findByPaymentId(Long paymentId) {
		// TODO Auto-generated method stub
		return paymentRepository.findByPaymentId(paymentId);
	}

	@Override
	public Optional<Payment> findByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return paymentRepository.findByDate(date);
	}

	@Override
	public void deleteById(Long paymentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Payment payment) {
		// TODO Auto-generated method stub
		paymentRepository.deleteAll();
	}

	@Override
	public Payment saveOrUpdate(Payment payment) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payment);
	}

	@Override
	public Payment createOrder(Payment payment) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payment);
	}

}
