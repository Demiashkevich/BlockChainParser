package com.dzemiashkevich.parser.strategy;

@FunctionalInterface
public interface Strategy<T> {
    void execute(final T utxo);
}
