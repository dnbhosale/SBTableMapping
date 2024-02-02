package com.SBTableMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SBTableMapping.OneToOne.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
