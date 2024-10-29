package com.democrud.democrud.service;

import com.democrud.democrud.model.Person;
import io.reactivex.Single;

public interface PersonService {

    Single<Person> getPerson(Integer id);
}
