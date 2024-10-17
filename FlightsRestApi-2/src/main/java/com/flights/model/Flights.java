package com.flights.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights_info")
public class Flights {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Flight_Name")
	private String name;
	@Column(name = "Source")
	private String source;
	@Column(name = "Destination")
	private String destiination;
	@Column(name = "Price")
	private int price;
	
	public Flights() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flights(String name, String source, String destiination, int price) {
		super();
		this.name = name;
		this.source = source;
		this.destiination = destiination;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestiination() {
		return destiination;
	}

	public void setDestiination(String destiination) {
		this.destiination = destiination;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	
	

}
