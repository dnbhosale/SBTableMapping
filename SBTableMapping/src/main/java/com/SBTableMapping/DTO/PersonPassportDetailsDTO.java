package com.SBTableMapping.DTO;

import com.SBTableMapping.OneToOne.Entity.Passport;
import com.SBTableMapping.OneToOne.Entity.Person;

public class PersonPassportDetailsDTO {
	
	private Long personId;
    private String name;
    private int age;
    private String passportNumber;
    private String expirationDate;

    public PersonPassportDetailsDTO(Person person, Passport passport) {
        this.personId = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
        this.passportNumber = passport.getPassportNumber();
        this.expirationDate = passport.getExpirationDate();
    }

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
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
