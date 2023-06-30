package com.example.spring.services;

import com.example.spring.entities.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.spring.repo.peopleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {
    private peopleRepository peopleRepository;

    public PeopleService(com.example.spring.repo.peopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    @Autowired


    // Metoda do pobierania listy wszystkich osób
    public List<People> getAllPeople() {
        return peopleRepository.findAll();
    }

    // Metoda do dodawania nowej osoby
    public People addPerson(People person) {
        return peopleRepository.save(person);
    }

    // Metoda do usuwania osoby o podanym identyfikatorze
    public void deletePerson(Long id) {
        peopleRepository.deleteById(id);
    }

    // Metoda do pobierania osoby o podanym identyfikatorze
    public Optional<People> getPersonById(Long id) {
        return peopleRepository.findById(id);
    }

    // Metoda do aktualizowania danych osoby
    public People updatePerson(People person) {
        return peopleRepository.save(person);
}
}
