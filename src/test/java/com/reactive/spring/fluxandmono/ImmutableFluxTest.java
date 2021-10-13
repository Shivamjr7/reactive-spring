package com.reactive.spring.fluxandmono;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class ImmutableFluxTest {

    /**
     * Flux are immutable
     */
    @Test
    public  void immutableFlux()
    {

        Flux<String > names = Flux.just("shivam","asif","abhinav").log();

        //this would create a new flux and not change the original flux
        names.map(String :: toUpperCase);


        //this will pass as no change to original flux
        StepVerifier.create(names)
                .expectSubscription()
                .expectNext("shivam","asif","abhinav")
                .verifyComplete();
    }
}
