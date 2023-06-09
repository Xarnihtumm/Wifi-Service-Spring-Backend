package com.hostmdy.wifiservice.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name="devices")
public class WifiUser {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private Long wificode;
	
	
	@NotBlank(message="Enter Your Name")
	private String name;
	
	


	@NotBlank(message = "NRC is required")
	@Column(unique = true)
	private String nrc;
	
	
	@NotNull(message="No Acess Your Location")
	private Double longitude;
	
	
	@NotNull(message="No Access Your Location")
	private Double latitude;
	
	
	@NotBlank(message="Fill Your Phone")
	private String phNo;


	public WifiUser(Long id, Long wificode, @NotBlank(message = "Enter Your Name") String name,
			@NotBlank(message = "NRC is required") String nrc,
			@NotNull(message = "No Acess Your Location") Double longitude,
			@NotNull(message = "No Access Your Location") Double latitude,
			@NotBlank(message = "Fill Your Phone") String phNo) {
		super();
		this.id = id;
		this.wificode = wificode;
		this.name = name;
		this.nrc = nrc;
		this.longitude = longitude;
		this.latitude = latitude;
		this.phNo = phNo;
	}
	
	
	
	
	
	

}
