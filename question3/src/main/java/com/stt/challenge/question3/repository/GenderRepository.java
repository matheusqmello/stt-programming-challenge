package com.stt.challenge.question3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stt.challenge.question3.model.Gender;

public interface GenderRepository extends JpaRepository<Gender, Integer> {

}
