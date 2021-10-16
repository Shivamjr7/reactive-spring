package com.reactive.spring.fluxandmono;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FlatMap converts 1 operation -> N operations
 * like A String to stream of characters
 */
public class FlatMapMonoTest {

    @Test
    public void flatMap() {

        Mono<List<String>> mono = Mono.just("Shivam")
                .flatMap(this::monoList)
                .log();

        StepVerifier.create(mono.log())
                .expectSubscription()
                .expectNext(new ArrayList<>(Arrays.asList("S", "h", "i", "v", "a", "m")))
                .verifyComplete();


    }


    public Mono<List<String>> monoList(String str) {
        String[] arr = str.split("");

        List<String> list = new ArrayList<>(Arrays.asList(arr));

        Mono<List<String>> monlist = Mono.just(list);
        return monlist;

    }
}
