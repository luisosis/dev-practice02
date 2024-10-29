package com.democrud.democrud.service;

import com.democrud.democrud.model.Cat;
import com.democrud.democrud.proxy.ClientFactoryCat;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CatServiceImpl implements CatService {

    @Autowired
    private ClientFactoryCat clientFactoryCat;

    @Override
    public Single<Cat> getCat() {
        return clientFactoryCat.getCat();
    }
}
