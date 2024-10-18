package com.thymeproj.model;

public class Bank {
	private int id;
	private String name;
	private String branch;
	private String ifsc;
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Bank(int id, String name, String branch, String ifsc) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.ifsc = ifsc;
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
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	
	
	

}
