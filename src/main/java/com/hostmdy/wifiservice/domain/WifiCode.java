package com.hostmdy.wifiservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="wificode")
@NoArgsConstructor
public class WifiCode {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@Column(unique = true)
	private Long wificode;


	public WifiCode(Long id, @NotNull(message = "You have no wificode") Long wificode) {
		super();
		this.id = id;
		this.wificode = wificode;
	}
	
	
	
	
	
}
