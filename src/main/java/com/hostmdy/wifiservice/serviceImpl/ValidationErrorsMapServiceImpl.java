package com.hostmdy.wifiservice.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.hostmdy.wifiservice.service.ValidationErrorsMapService;


@Service
public class ValidationErrorsMapServiceImpl implements ValidationErrorsMapService {

	@Override
	public ResponseEntity<?> validate(BindingResult result) {
		// TODO Auto-generated method stub
		if(result.hasErrors()) {
			Map<String,String> errorMap = new HashMap<>();
			List<FieldError> errors= result.getFieldErrors();
			
			for(final FieldError error:errors)
				errorMap.put(error.getField(),error.getDefaultMessage());
			
			return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
		
		return null;
	}

}
