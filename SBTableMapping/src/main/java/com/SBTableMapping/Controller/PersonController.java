package com.SBTableMapping.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SBTableMapping.DTO.PersonDTO;
import com.SBTableMapping.DTO.PersonPartialDTO;
import com.SBTableMapping.DTO.PersonPassportDetailsDTO;
import com.SBTableMapping.OneToOne.Entity.Passport;
import com.SBTableMapping.OneToOne.Entity.Person;
import com.SBTableMapping.Services.PassportServices;
import com.SBTableMapping.Services.PersonServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	PersonServices personServices;
	@Autowired
	PassportServices passportServices;

	@PostMapping("/add")
	public ResponseEntity<String> addPerson(@Valid @RequestBody PersonDTO personDTO) {

		try {
			Person person = new Person(personDTO.getName(), personDTO.getAge());
			Passport passport = new Passport(personDTO.getPassportNumber(), personDTO.getExpirationDate());
			passport.setPerson(person);
			person.setPassport(passport);
			personServices.savePerson(person);
			return ResponseEntity.ok("person and passport has been added successfully !!");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(500).body("Error -" + e.getMessage());
		}

	}

	@GetMapping("/{personId}")
	public ResponseEntity<?> getPersonDetails(@PathVariable Long personId) {

		try {
			Person person = personServices.getPersonById(personId);
			Passport passport = passportServices.getPassportById(personId);

			PersonPassportDetailsDTO p = new PersonPassportDetailsDTO(person, passport);
			return ResponseEntity.ok(p);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
			// TODO: handle exception
		}
	}

	@GetMapping("/pp/{id}")
	public ResponseEntity<PersonPartialDTO> getPersonPartialData(@PathVariable Long id) {
		try {

			Person person = personServices.getPersonById(id);
			return ResponseEntity.ok(covertToPartialDTO(person));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	  @DeleteMapping("/delete/{id}")
	public String deletePersonAndPassport(@PathVariable(name="id") Long personId) {
		try {
			personServices.deletePersonAndPassport(personId);
			return "person and passport has been deleted" +personId;
		} catch (Exception e) {
			// TODO: handle exception
			return "Failed to delete" + e.getMessage();
		}
		 
	}

	private PersonPartialDTO covertToPartialDTO(Person person) {
		PersonPartialDTO personPartialDTO = new PersonPartialDTO();
		personPartialDTO.setName(person.getName());
		Passport passport = person.getPassport();
		if (passport != null) {
			personPartialDTO.setPassportNumber(passport.getPassportNumber());
		}

		return personPartialDTO;

	}
	
	

}
