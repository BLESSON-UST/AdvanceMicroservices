package com.ust.springbootwebflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFlexTest {
    @Test
    public void testMono(){
        Mono<?> monoString = Mono.just("Blesson").log();
        monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }


    @Test
    public void testFlux(){
        Flux<?> fluxString = Flux.just("Blesson","abcde").concatWithValues("aws").concatWithValues("cloud").log();
        fluxString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }
}
