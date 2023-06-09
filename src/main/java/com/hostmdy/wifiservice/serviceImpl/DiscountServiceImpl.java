package com.hostmdy.wifiservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.wifiservice.domain.Discount;
import com.hostmdy.wifiservice.repository.DiscountRepository;
import com.hostmdy.wifiservice.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {
	
	private final DiscountRepository discountRepository;
	
	
    @Autowired
	public DiscountServiceImpl(DiscountRepository discountRepository) {
		super();
		this.discountRepository = discountRepository;
	}

	@Override
	public List<Discount> findAll() {
		// TODO Auto-generated method stub
		return (List<Discount>) discountRepository.findAll();
	}

	@Override
	public Optional<Discount> findById(Long id) {
		// TODO Auto-generated method stub
		return discountRepository.findById(id);
	}

	@Override
	public Optional<Discount> findByName(String discountName) {
		// TODO Auto-generated method stub
		return discountRepository.findByDiscountName(discountName);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		discountRepository.deleteById(id);
	}

	@Override
	public void DeleteAll(Discount discount) {
		// TODO Auto-generated method stub
		discountRepository.deleteAll();
	}

	@Override
	public Discount saveOrUpdateDiscount(Discount discount) {
		// TODO Auto-generated method stub
		return discountRepository.save(discount);
	}

	@Override
	public Discount createDiscount(Discount discount) {
		// TODO Auto-generated method stub
		return discountRepository.save(discount);
	}

}
