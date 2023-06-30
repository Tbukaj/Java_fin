package com.example.spring.repo;

import com.example.spring.entities.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface peopleRepository extends JpaRepository<People, Long> {


}
