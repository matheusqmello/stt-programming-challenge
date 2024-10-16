package com.stt.challenge.question3.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stt.challenge.question3.exception.WrongIdExcpetion;
import com.stt.challenge.question3.model.Person;
import com.stt.challenge.question3.repository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    // SAVE
    public void save(@Valid Person person) {
        personRepository.save(person);
    }
    
    public void update(Integer id, @Valid Person person) throws WrongIdExcpetion {
        if (id != person.getIdPerson()) {
            throw new WrongIdExcpetion("Cannot update: Id "+id+" is different from the original Person: "+person.getIdPerson()+", "+person.getFullName());
        }
        
        personRepository.save(person);
    }
    
    // DELETE    
    public void delete(Integer id) {
        personRepository.deleteById(id);
    }
    
    // QUERIES
    public Person getById(Integer id) {
        return personRepository.getById(id);
    }
    
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
