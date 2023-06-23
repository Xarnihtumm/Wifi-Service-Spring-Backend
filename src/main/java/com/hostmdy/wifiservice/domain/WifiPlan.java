package com.hostmdy.wifiservice.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Plan")
public class WifiPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Please provide your name")
	private String planName;

	// @JsonManagedReference
	// @JsonIgnore
//	@OneToMany(mappedBy = "plan", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@OneToMany(mappedBy = "plan", cascade = CascadeType.PERSIST, orphanRemoval = true)
	@JsonManagedReference
	private List<Speed> speed = new ArrayList<>();

	public WifiPlan(Long id, @NotBlank(message = "Please provide your name") String planName) {
		super();
		this.id = id;
		this.planName = planName;
	}

}
