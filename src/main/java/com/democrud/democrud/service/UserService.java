package com.democrud.democrud.service;

import com.democrud.democrud.model.User;
import io.reactivex.Single;

public interface UserService {
    Single<User> getUser(Integer id);
    Single<User> findByName(String name);

    Single<User> saveUser(User user);
}
