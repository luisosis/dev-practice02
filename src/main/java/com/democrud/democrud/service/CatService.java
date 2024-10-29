package com.democrud.democrud.service;

import com.democrud.democrud.model.Cat;
import io.reactivex.Single;

public interface CatService {

    Single<Cat> getCat();
}
