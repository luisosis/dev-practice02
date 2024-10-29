package com.democrud.democrud.controller;

import com.democrud.democrud.model.Person;
import com.democrud.democrud.service.PersonService;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController controller;


    @Test
    public void whenGetPersonsSuccess(){

        var person = new Person();
        person.setId(1);
        person.setName("name");
        person.setApeFather("father");
        person.setApeMother("test");

        Mockito.when(this.personService.getPerson(Mockito.any()))
                .thenReturn(Single.just(person));

        //TestObserver<Person> observer
        TestObserver<Person> observer =  this.controller.getPersons(1).test();

        observer.awaitTerminalEvent();
        observer.assertNoErrors();
        observer.dispose();

    }
}
