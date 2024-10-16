package com.stt.challenge.question3.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stt.challenge.question3.exception.WrongIdExcpetion;
import com.stt.challenge.question3.model.Gender;
import com.stt.challenge.question3.repository.GenderRepository;

@Service
public class GenderService {
    
    @Autowired
    private GenderRepository genderRepository;

    // SAVE
    public void save(@Valid Gender gender) {
        genderRepository.save(gender);
    }
    
    public void update(Integer id, @Valid Gender gender) throws WrongIdExcpetion {
        if (id != gender.getIdGender()) {
            throw new WrongIdExcpetion("Cannot update: Id "+id
                    +" is different from the original Gender: "
                    +gender.getIdGender()+", "+gender.getName());
        }
        
        genderRepository.save(gender);
    }
    
    // DELETE    
    public void delete(Gender gender) {
        genderRepository.delete(gender);
    }
    
    // QUERIES
    public Gender getById(Integer id) {
        return genderRepository.getById(id);
    }
    
    public List<Gender> getAll() {
        return genderRepository.findAll();
    }
    
}
