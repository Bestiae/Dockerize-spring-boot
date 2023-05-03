package com.capco.expensesapp.controllers;

import com.capco.expensesapp.dtos.PersonDTO;
import com.capco.expensesapp.dtos.PersonShortDTO;
import com.capco.expensesapp.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/size")
    public ResponseEntity<Integer> countAllPerson() {
        log.info("personService.countAllPerson();");
        return ResponseEntity.ok().body(personService.countAllPerson());
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonDTO>> getAllPersons(){
        log.info("personService.getAllUsers();");
        return ResponseEntity.ok().body(personService.getAllUsers());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PersonDTO> getFriendById(@PathVariable(value = "id") Long id) {
        log.info("getFriendById({})", id);
        return ResponseEntity.ok().body(personService.findPersonById(id));
    }

    @GetMapping("/get-short/{id}")
    public ResponseEntity<PersonShortDTO> getFriendShortById(@PathVariable(value = "id") Long id) {
        log.info("getFriendShortById({})", id);
        return ResponseEntity.ok().body(personService.findPersonShortById(id));
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PersonDTO> addFriend(@RequestBody @Valid PersonDTO personDTO) {
        log.info("personService.addFriend({})", personDTO);
        return ResponseEntity.ok().body(personService.addFriend(personDTO));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFriendById(@PathVariable(value = "id") Long id) {
        log.info("personService.deletePersonById({});", id);
        try {
            personService.deletePersonById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println("nothing will be done, not found exception.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name")
    public ResponseEntity<List<PersonDTO>> findPersonByName(@RequestParam String name) {
        log.info("personService.findByFullName({});", name);
        return ResponseEntity.ok().body(personService.findByFullName(name));
    }

    @GetMapping("/get")
    public ResponseEntity<List<PersonDTO>> findALlByCountry(@RequestParam String country) {
        log.info("personService.findAllPersonByCountry({}});", country );
        return ResponseEntity.ok().body(personService.findAllPersonByCountry(country));
    }
}
