package com.cg.sonwane.ems.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Document
public class Employee {
	@Transient
    public static final String SEQUENCE_NAME = "employee_sequence";
	
	@Id
	private int id;
	
	@NotEmpty
	@Size(min=3,message="Name Should be greater than 3 character")
	private String name;
	
	@NotEmpty
	@Size(min=3,message="Name Should not be Empty")
	private String department;
	private String designation;
	private Address address;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, String department, String designation, Address adress) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.designation = designation;
		this.address = adress;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", designation=" + designation
				+ ", adress=" + address + "]";
	}

	
	

}
