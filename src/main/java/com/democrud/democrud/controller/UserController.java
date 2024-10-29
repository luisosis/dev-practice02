package com.democrud.democrud.controller;

import com.democrud.democrud.model.User;
import com.democrud.democrud.service.UserService;
import io.reactivex.Completable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@AllArgsConstructor
public class UserController {

    //@Autowired
    private final UserService userService;

    @GetMapping(value = "/userupd/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Single<User> getuser(@PathVariable(name = "id") Integer id){
        return userService.getUser(id)
                .doOnSuccess(person -> log.info("getPersons success - finish"))
                .doOnError(throwable -> log.error("get persons error {0}", throwable));
    }

    @GetMapping(value = "/user/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Single<User> getUserByName(@PathVariable(name = "name") String name){
        return userService.findByName(name)
                .doOnSuccess(person -> log.info("getUserByName success - finish"))
                .doOnError(throwable -> log.error("get getUserByName error {0}", throwable));
    }

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Completable getUserByName(@RequestBody User user) {
        return userService.saveUser(user)
                .ignoreElement();
                //.doOnSuccess(person -> log.info("getUserByName success - finish"))
                //.doOnError(throwable -> log.error("get getUserByName error {0}", throwable));
    }
}
