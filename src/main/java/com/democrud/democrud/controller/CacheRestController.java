//package com.democrud.democrud.controller;
//
//
//import com.democrud.democrud.config.CacheRedisProperties;
//import com.democrud.democrud.model.Employee;
//import com.democrud.democrud.repository.CacheRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;
//
//import java.time.Duration;
//
//@RestController
//public class CacheRestController {
//
//    @Autowired
//    private CacheRepository repository;
//
//    @Autowired
//    private CacheRedisProperties cacheRedisProperties;
//
//    @RequestMapping(value = "/employees",
//            produces = { "application/json;charset=UTF-8", "application/json" },
//            consumes = { "application/json" },
//            method = RequestMethod.POST)
//    Mono<Boolean> save(@RequestBody Employee employee) {
//        return repository.save(
//                cacheRedisProperties.getName(),
//                cacheRedisProperties.getKey(),
//                employee,
//                Duration.ofSeconds(3600L)
//                //Duration.ofSeconds(cacheRedisProperties.getSecondsToLive())
//        );
//    }
//
//    @RequestMapping(value = "/employees",
//            produces = { "application/json;charset=UTF-8", "application/json", "application/stream+json" },
//            consumes = { "application/json" },
//            method = RequestMethod.GET)
//    Mono<Employee> getEmployee() {
//        return repository.getObject(
//                cacheRedisProperties.getName(),
//                cacheRedisProperties.getKey()
//        ).cast(Employee.class);
//    }
//}
