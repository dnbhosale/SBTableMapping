package com.SBTableMapping.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SBTableMapping.OneToOne.Entity.Passport;
import com.SBTableMapping.OneToOne.Entity.Person;
import com.SBTableMapping.Repository.PassportRepository;
import com.SBTableMapping.Repository.PersonRepository;

import jakarta.transaction.Transactional;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository personRepository;
	@Autowired
	PassportRepository passportRepository;
	
	public void savePerson(Person person) {
        personRepository.save(person);
    }

	public Person getPersonById(Long personId) {
		
		return personRepository.findById(personId).orElseThrow(()-> new RuntimeException("Person not found by ID "+personId));
	}
	
	
	@Transactional
	public void deletePersonAndPassport(Long personId) {
		Person person=personRepository.findById(personId)
				.orElseThrow(()->new RuntimeException("person not foudn by this id "+personId));
		
		Passport passport=person.getPassport();
		personRepository.delete(person);
		
		if(passport !=null)passportRepository.delete(passport);
	}
	
	

}
