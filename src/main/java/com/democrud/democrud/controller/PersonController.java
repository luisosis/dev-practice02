package com.democrud.democrud.controller;

import com.democrud.democrud.model.Person;
import com.democrud.democrud.service.PersonService;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@AllArgsConstructor
public class PersonController {

    //@Autowired
    private final PersonService personService;

    @GetMapping(value = "/persons/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Single<Person> getPersons(@PathVariable Integer id){
        return personService.getPerson(id)
                .doOnSuccess(person -> log.info("getPersons success - finish"))
                .doOnError(throwable -> log.error("get persons error {0}", throwable));
    }
}
