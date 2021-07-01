package com.luv2code.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="country")
@Getter
@Setter
public class Country {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private String code;

	@Column
	private String name;

	@OneToMany(mappedBy = "country")
	@JsonIgnore
	private List<State> states;
}
