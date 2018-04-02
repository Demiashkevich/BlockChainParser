package com.dzemiashkevich.parser.strategy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public abstract class AbstractStrategy<T> implements Strategy<T> {

    private static final String HEX_PATH = "." + File.separator + "hex.txt";

    private static BufferedWriter writer;

    static {
        try {
             writer = Files.newBufferedWriter(Paths.get(HEX_PATH), StandardOpenOption.APPEND);
        } catch (IOException exception) {
            throw new RuntimeException("Unable write to file by path: " + HEX_PATH, exception);
        }
    }

    protected void write(final String line) {
        try {
            writer.write(line + System.lineSeparator());
        } catch (IOException exception) {
            throw new RuntimeException("Unable write to file by path: " + HEX_PATH, exception);
        }
    }

}
