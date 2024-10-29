package com.democrud.democrud.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Value("${cache.user.info.ttl:5}")
    private long cacheUsersInfoTtl;

    @Value("${cache.user.info.max-size:3}")
    private long cacheUsersInfoMaxSize;

    public static final String USER_INFO_CACHE = "USER_INFO_CACHE";

    @Bean
    public CacheManager cacheManager() {
        List<CaffeineCache> caches = new ArrayList<>();

        caches.add(buildCache(USER_INFO_CACHE,cacheUsersInfoTtl,TimeUnit.SECONDS,  cacheUsersInfoMaxSize));

        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(caches);
        return manager;
    }

    private static CaffeineCache buildCache(String name, long ttl, TimeUnit timeUnit, long size) {
        return new CaffeineCache(name, Caffeine.newBuilder()
                .expireAfterWrite(ttl,timeUnit)
                .maximumSize(size)
                .build());

    }


}
