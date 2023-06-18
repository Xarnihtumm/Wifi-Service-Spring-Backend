package com.hostmdy.wifiservice.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "speed")
public class Speed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Chooser Your Speed")
	private Integer mb;

	@ManyToOne
	@JoinColumn(name = "plan_id")
	//@JsonIgnore
	 @JsonBackReference
	private WifiPlan plan;

	
	@OneToMany(mappedBy = "speed", orphanRemoval = true)
	@JsonManagedReference
	private List<Discount> discount = new ArrayList<>();


	public Speed(Long id, @NotNull(message = "Chooser Your Speed") Integer mb) {
		super();
		this.id = id;
		this.mb = mb;
	}

	
}
