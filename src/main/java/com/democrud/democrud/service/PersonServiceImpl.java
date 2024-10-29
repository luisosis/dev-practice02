package com.democrud.democrud.service;

import com.democrud.democrud.model.Person;
import com.democrud.democrud.repository.PersonRepository;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Single<Person> getPerson(Integer id) {
        return Single.fromCallable(() ->  personRepository.findById(id)
                .orElseGet(Person::new));
    }
}
