package com.jobs.job_vacancies.controllers;

import com.jobs.job_vacancies.controllers.dtos.RegisteredPersonDTO;
import com.jobs.job_vacancies.entities.registeredPerson.RegisteredPerson;
import com.jobs.job_vacancies.services.RegisteredPersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/registered-person")
public class RegisteredPersonController {
    @Autowired
    private RegisteredPersonService registeredPersonService;

    @PostMapping
    public final ResponseEntity<RegisteredPerson> createRegisteredPerson(
            @RequestBody @Valid RegisteredPersonDTO dto
    ) {
        RegisteredPerson registeredPerson = this.registeredPersonService.createRegisteredPerson(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/registered-person")
                .buildAndExpand(registeredPerson.getId()).toUri();
        return ResponseEntity.created(uri).body(registeredPerson);
    }
}
