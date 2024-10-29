package com.democrud.democrud.proxy;

import com.democrud.democrud.model.Cat;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Mono;


@Service
public class ClientFactoryCatImpl implements ClientFactoryCat{

    @Autowired
    private WebClient.Builder WebClient;

    @Override
    public Single<Cat> getCat() {
        String url = "https://catfact.ninja/fact";

        Mono<Cat> monoCat = WebClient.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Cat.class);
        return RxJava2Adapter.monoToSingle(monoCat);
    }

}
