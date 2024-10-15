package com.stt.challenge.question3.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
public @Data class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPerson;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender idGender;

    @NotNull
    @Size(max = 50)
    private String fullName;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;
}
