package com.greenjava.lambda;

import java.util.Objects;

@FunctionalInterface
public interface Sum<F, S> {

    void add(F f, S s);

    // default methods are chaining
    default Sum<F, S> addThen(Sum<F, S> other) {
        Objects.requireNonNull(other);
        return (F f, S s) -> {
            this.add(f, s);
            other.add(f, s);
        };
    }
}
