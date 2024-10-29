package com.democrud.democrud.controller;

import com.democrud.democrud.model.Cat;
import com.democrud.democrud.service.CatService;
import io.reactivex.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping(value = "/cats")
    @ResponseStatus(HttpStatus.OK)
    private Maybe<Cat> getCat(){
        return catService.getCat().toMaybe();
    }

}
