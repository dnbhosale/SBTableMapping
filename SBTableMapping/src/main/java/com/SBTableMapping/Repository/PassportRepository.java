package com.SBTableMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SBTableMapping.OneToOne.Entity.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> {

	 

}
