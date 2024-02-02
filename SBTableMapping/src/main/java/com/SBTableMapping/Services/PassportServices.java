package com.SBTableMapping.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SBTableMapping.OneToOne.Entity.Passport;
import com.SBTableMapping.Repository.PassportRepository;

@Service
public class PassportServices {
	
	@Autowired
	PassportRepository passportRepository;
	
	public void savePassport(Passport passport) {
		passportRepository.save(passport);
	}

	public Passport getPassportById(Long personId) {
		return passportRepository.findById(personId)
				.orElseThrow(()-> new RuntimeException("passport not found by personid  "+personId));
	}

}
