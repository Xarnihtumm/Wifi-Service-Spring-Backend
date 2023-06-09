package com.hostmdy.wifiservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="speed")
public class Speed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	@NotNull(message="Chooser Your Speed")
	private Integer mb;
	
	 @ManyToOne
	    @JoinColumn(name = "plan_id")
	    @JsonIgnore
	    private WifiPlan plan;
	
	@NotNull(message="Pay For Prices")
	private Double prices;

	public Speed(Long id, @NotNull(message = "Chooser Your Speed") Integer mb,
			@NotNull(message = "Pay For Prices") Double prices) {
		super();
		this.id = id;
		this.mb = mb;
		this.prices = prices;
	}

	

	

	

	

	
	
	
	
}
