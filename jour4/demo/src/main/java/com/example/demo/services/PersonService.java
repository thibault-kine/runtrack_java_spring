package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.models.PersonEntity;

@Service
@Primary
public interface PersonService extends JpaRepository<PersonEntity, Integer> {

    // CREATE
    void createPerson(String fname, String lname, int age);

    // READ ONE
    Optional<PersonEntity> getPerson(int id);

    // READ ALL
    List<PersonEntity> getAllPersons();

    // UPDATE
    void updatePerson(int id, String firstName, String lastName, int age);

    // DELETE
    void deletePerson(int id);
}
