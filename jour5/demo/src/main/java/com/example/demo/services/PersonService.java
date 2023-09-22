package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.PersonRepository;
import com.example.demo.models.PersonEntity;

@Service
public class PersonService {
    
    private PersonRepository repo;

    
    @Autowired
    public PersonService(PersonRepository repository) { this.repo = repository; }

    public void createPerson(String firstName, String lastName, int age, String email, String password) {
        repo.save(new PersonEntity(firstName, lastName, age, email, password));
    }

    public List<PersonEntity> getAll() {
        return repo.findAll();
    }

    public Optional<PersonEntity> getOneByID(int id) {
        return repo.findById(id);
    }

    public void updatePerson(int id, String firstName, String lastName, int age, String email, String password) {
        PersonEntity p = getOneByID(id).get();
        p.setAge(age);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setEmail(email);
        p.setPassword(password);
    }

    public void deletePerson(int id) {
        repo.delete(getOneByID(id).get());
    }
}
