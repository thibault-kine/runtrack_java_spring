package com.example.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    
}
