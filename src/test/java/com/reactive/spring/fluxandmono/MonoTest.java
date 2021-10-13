package com.reactive.spring.fluxandmono;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class MonoTest {


    @Test
    public void monoTest()
    {
        Mono<String> name = Mono.just("Shivam");

        StepVerifier.create(name)
                .expectSubscription()
                .expectNext("Shivam")
                .verifyComplete();
    }


}
