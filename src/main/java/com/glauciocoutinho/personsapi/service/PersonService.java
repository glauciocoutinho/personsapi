package com.glauciocoutinho.personsapi.service;

import com.glauciocoutinho.personsapi.dto.request.PersonDTO;
import com.glauciocoutinho.personsapi.dto.response.MessageResponseDTO;
import com.glauciocoutinho.personsapi.entity.Person;
import com.glauciocoutinho.personsapi.mapper.PersonMapper;
import com.glauciocoutinho.personsapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(@Valid PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created personDTO with ID " + savedPerson.getId())
                .build();
    }
}
