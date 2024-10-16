package com.stt.challenge.question3.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "TB_PERSON")
public @Data class Person {
    
    public Person() {}
    
    public Person(@NotNull Gender idGender, @NotNull @Size(max = 50) String fullName, @NotNull LocalDate birthdate) {
        super();
        this.idGender = idGender;
        this.fullName = fullName;
        this.birthdate = birthdate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPerson;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_GENDER", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender idGender;

    @NotNull
    @Size(max = 50)
    private String fullName;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;
}
