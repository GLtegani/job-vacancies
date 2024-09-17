package com.jobs.job_vacancies.controllers;

import com.jobs.job_vacancies.controllers.dtos.RegisteredPersonDTO;
import com.jobs.job_vacancies.entities.registeredPerson.RegisteredPerson;
import com.jobs.job_vacancies.services.RegisteredPersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
           .buildAndExpand(registeredPerson.getId())
           .toUri();
        return ResponseEntity.created(uri).body(registeredPerson);
    }

    @GetMapping
    public final ResponseEntity<List<RegisteredPerson>> findAllRegisteredPeople() {
        List<RegisteredPerson> registeredPeople = this.registeredPersonService.findAllRegisteredPeople();
        return ResponseEntity.ok(registeredPeople);
    }
}
