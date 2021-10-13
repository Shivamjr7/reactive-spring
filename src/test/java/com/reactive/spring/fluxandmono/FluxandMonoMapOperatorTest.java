package com.reactive.spring.fluxandmono;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxandMonoMapOperatorTest {


    @Test
    public  void fluxmap()
    {
        /**
         * map operator to convert stream from one form to another
         */
        Flux<String> names = Flux.fromIterable(List.of("asif","shivam","abhinav","gaurav"))
                .map(String::toUpperCase).log();

        StepVerifier.create(names)
                .expectSubscription()
                .expectNext("ASIF","SHIVAM","ABHINAV","GAURAV")
                .verifyComplete();


    }

    @Test
    public void monoMap()
    {
        Mono<String> name = Mono.just("Shivam")
                .map(names -> names.concat(" Jari")).log();


        StepVerifier.create(name)
                .expectNext("Shivam Jari")
                .verifyComplete();
    }
}
