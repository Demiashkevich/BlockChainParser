package com.dzemiashkevich.parser.util;

import com.dzemiashkevich.parser.strategy.Strategy;

import java.io.Serializable;
import java.util.List;

@FunctionalInterface
public interface FileSaver<T extends Serializable> {
    void execute(final Strategy<T> strategy, final List<T> type);
}
