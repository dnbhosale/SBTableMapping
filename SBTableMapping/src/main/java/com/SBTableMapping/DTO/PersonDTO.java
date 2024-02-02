package com.SBTableMapping.DTO;

public class PersonDTO {
	
    private String name;
    private int age;
    private String passportNumber;
    private String expirationDate;
    
    
    
    
	public PersonDTO(String name, int age, String passportNumber, String expirationDate) {
		super();
		this.name = name;
		this.age = age;
		this.passportNumber = passportNumber;
		this.expirationDate = expirationDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
    
    

}
