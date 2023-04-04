package com.cg.sonwane.ems.model;


public class Address {

	private long id;
	private String apartmentName;
	private String floor;
	private String street;
	private String city;
	private int pincode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(long id, String apartmentName, String floor, String street, String city, int pincode) {
		super();
		this.id = id;
		this.apartmentName = apartmentName;
		this.floor = floor;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", apartmentName=" + apartmentName + ", floor=" + floor + ", street=" + street
				+ ", city=" + city + ", pincode=" + pincode + "]";
	}
}
