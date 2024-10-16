package com.stt.challenge.question3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stt.challenge.question3.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
