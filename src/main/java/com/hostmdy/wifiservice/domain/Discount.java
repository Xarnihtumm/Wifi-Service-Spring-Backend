package com.hostmdy.wifiservice.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="discount")
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Enter Your month")
	private Integer months;
	
	@NotNull(message = "Pay For Prices")
	private Double prices;
	
	@NotBlank(message="Fill Your Name")
	private String discountName;
	

	@NotBlank(message="Fill Your Amount")
	private String discountAmount;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "speed_id")
	    @JsonBackReference
	    private Speed speed;


//	public Discount(Long id, @NotNull(message = "Enter Your month") Integer months,
//			@NotBlank(message = "Fill Your Name") String discountName,
//			@NotBlank(message = "Fill Your Amount") String discountAmount) {
//		super();
//		this.id = id;
//		this.months = months;
//		this.discountName = discountName;
//		this.discountAmount = discountAmount;
//	}
	
	
	

}
