package com.firstrest.model;

public class Trainer {
	private String name;

	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Trainer [name=" + name + "]";
	}
	
	

}
