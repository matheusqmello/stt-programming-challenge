package com.stt.challenge.question3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "TB_GENDER")
@Data
public class Gender {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGender;
    
    @NotNull
    @Size(max = 10)
    private String name;
}
