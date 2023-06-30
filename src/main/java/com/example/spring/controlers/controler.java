package com.example.spring.controlers;

import com.example.spring.entities.People;
import com.example.spring.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class controler {
    private PeopleService peopleService;

    public controler(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Autowired

    @GetMapping
    public ResponseEntity<List<People>> getAllPeople() {
        List<People> people = peopleService.getAllPeople();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<People> addPerson(@RequestBody People person) {
        People newPerson = peopleService.addPerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<People> getPersonById(@PathVariable Long id) {
        Optional<People> person = peopleService.getPersonById(id);
        return person.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<People> updatePerson(@PathVariable Long id, @RequestBody People person) {
        Optional<People> existingPerson = peopleService.getPersonById(id);

        if (existingPerson.isPresent()) {
            person.setId(id);
            People updatedPerson = peopleService.updatePerson(person);
            return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        Optional<People> existingPerson = peopleService.getPersonById(id);

        if (existingPerson.isPresent()) {
            peopleService.deletePerson(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

