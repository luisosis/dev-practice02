package com.democrud.democrud.proxy;

import com.democrud.democrud.model.Cat;
import io.reactivex.Single;

public interface ClientFactoryCat {

    Single<Cat> getCat();
}
