package com.zxu.result;

import java.util.Objects;

@FunctionalInterface
public interface MsgResultFunction<T, R> {

    R apply(T t) throws Exception;

    default <V> MsgResultFunction<V, R> compose(MsgResultFunction<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    default <V> MsgResultFunction<T, V> andThen(MsgResultFunction<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    static <T> MsgResultFunction<T, T> identity() {
        return t -> t;
    }

}
