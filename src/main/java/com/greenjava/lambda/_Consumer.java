package com.greenjava.lambda;

import java.util.Objects;

@FunctionalInterface
public interface _Consumer<T> {

    void accept(T t);

    // adding default method provide a way to chain lambada
    // and modify the behave o lambda
    // off course don't forget fail fast requireNonNull
    default _Consumer<T> andThen(_Consumer<T> other) {
        Objects.requireNonNull(other);
        return (T t) -> {
            this.accept(t);
            other.accept(t);
        };
    }
}
