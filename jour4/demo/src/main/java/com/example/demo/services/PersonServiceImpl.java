package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.PersonRepository;
import com.example.demo.models.PersonEntity;

@Service
public class PersonServiceImpl implements PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    // CREATE
    @Override
    public void createPerson(String fname, String lname, int age) {
        PersonEntity p = new PersonEntity(fname, lname, age);
        personRepository.save(p);
    }

    // READ ONE
    @Override
    public Optional<PersonEntity> getPerson(int id) {
        return personRepository.findById(id);
    }

    // READ ALL
    @Override
    public List<PersonEntity> getAllPersons() {
        return personRepository.findAll();
    }

    // UPDATE
    @Override
    public void updatePerson(int id, String firstName, String lastName, int age) {
        PersonEntity p = personRepository.findById(id).get();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(age);
    }

    // DELETE
    @Override
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    //#region stupid implementations
    @Override
    public void flush() {

    }

    @Override
    public <S extends PersonEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends PersonEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<PersonEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PersonEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public PersonEntity getById(Integer integer) {
        return null;
    }

    @Override
    public PersonEntity getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends PersonEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PersonEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PersonEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PersonEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PersonEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PersonEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends PersonEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends PersonEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PersonEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PersonEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public List<PersonEntity> findAll() {
        return null;
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<PersonEntity> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(PersonEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends PersonEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Page<PersonEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<PersonEntity> findAll(Sort sort) {
        return null;
    }
    //#endregion
}
