package com.glauciocoutinho.personsapi.repository;

import com.glauciocoutinho.personsapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
