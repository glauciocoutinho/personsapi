package com.glauciocoutinho.personsapi.controller;


import com.glauciocoutinho.personsapi.dto.request.PersonDTO;
import com.glauciocoutinho.personsapi.dto.response.MessageResponseDTO;
import com.glauciocoutinho.personsapi.entity.Person;
import com.glauciocoutinho.personsapi.service.PersonService;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    public List<PersonDTO> listAll() {
        return personService.listAll();
    }
}
