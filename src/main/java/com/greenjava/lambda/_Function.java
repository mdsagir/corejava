package com.greenjava.lambda;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface _Function<T, R> {

    R apply(T t);

    // pass first input then second input return
    default <V> _Function<T, V> andThen(_Function<R, V> other) {
        Objects.requireNonNull(other);
        return (T t) -> {
            R apply = apply(t);
            return other.apply(apply);
        };
    }

    // pass second input then and first return
    default <V> _Function<V, R> compose(_Function<V, T> other) {
        Objects.requireNonNull(other);
        return (V v) -> {
            T t = other.apply(v);
            return apply(t);
        };
    }

    static <T> _Function<T, T> identity() {
        return t -> t;
    }
}
