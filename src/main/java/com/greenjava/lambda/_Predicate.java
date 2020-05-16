package com.greenjava.lambda;

import java.util.Objects;
import java.util.function.Predicate;

@FunctionalInterface
public interface _Predicate<T> {

    boolean test(T t);

    default _Predicate<T> and(_Predicate<T> other) {
        Objects.requireNonNull(other);
        return (T t) -> test(t) && other.test(t);

    }

    default _Predicate<T> negate() {
        return (T t) -> !this.test(t);
    }
}
