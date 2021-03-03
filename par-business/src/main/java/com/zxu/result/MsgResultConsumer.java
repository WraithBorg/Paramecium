package com.zxu.result;

import java.util.Objects;

@FunctionalInterface
public interface MsgResultConsumer<T> {

    void accept(T t) throws Exception;

    default MsgResultConsumer<T> andThen(MsgResultConsumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> {
            accept(t);
            after.accept(t);
        };
    }

}
