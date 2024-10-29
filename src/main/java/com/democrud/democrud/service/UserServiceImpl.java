package com.democrud.democrud.service;

import com.democrud.democrud.config.CacheConfig;
import com.democrud.democrud.model.User;
import com.democrud.democrud.repository.UserRepository;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Single<User> getUser(Integer id) {
        return Single.fromCallable(() -> userRepository.findById(id)
                .orElseGet(User::new));
    }

    @Override
    @Cacheable(value = CacheConfig.USER_INFO_CACHE, unless = "#result == null")
    public Single<User> findByName(String name) {
        log.info("Init method findByName ");
        return Single.fromFuture(userRepository.findByName(name))
                .doOnSuccess(user -> log.info("findByName Success"));
    }

    @Override
    public Single<User> saveUser(User user) {
        log.info("Init method saveUser ");
        return Single.fromCallable(() -> userRepository.save(user));
    }
}
