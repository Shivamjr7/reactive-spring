package com.reactive.spring.fluxandmono;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxTest {

    @Test
    public void fluxTest()
    {
        /**
         * Flux and Mono are publishers
         */
        Flux<String> flux = Flux.just("Asif","Shivam","Abhinav").log();

        flux.subscribe(System.out::println);

    }

    @Test
    public void fluxWithoutErrors()
    {

        Flux<String> names = Flux.just("Shivam","Abhinav","Asif");

        StepVerifier.create(names)
                .expectSubscription()
                .expectNext("Shivam")
                .expectNext("Abhinav")
                .expectNext("Asif")
                .expectComplete();
    }


    @Test
    public void fluxWithErrors()
    {

        /**
         * In case of error , verify should be called and not verify complete
         */
        Flux<String> names = Flux.just("Shivam","Abhinav","Asif")
                .concatWith(Flux.error(new RuntimeException("Runtime exception")));

        StepVerifier.create(names)
                .expectSubscription()
                .expectNext("Shivam")
                .expectNext("Abhinav")
                .expectNext("Asif")
                .expectError(RuntimeException.class)
                .verify();
    }


    @Test
    public void fluxinSingleLine()
    {

        Flux<String> names = Flux.just("Shivam","Abhinav","Asif").log();

        StepVerifier.create(names)
                .expectSubscription()
                .expectNext("Shivam","Abhinav","Asif")
                .verifyComplete();
    }


    @Test
    public void fluxCount()
    {

        Flux<String> names = Flux.just("Shivam","Abhinav","Asif");

        StepVerifier.create(names.log())
                .expectSubscription()
                .expectNextCount(3)
                .verifyComplete();
    }




}
