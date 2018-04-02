package com.dzemiashkevich.parser.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileScanner {

    public static Optional<List<File>> getAbsolutePath(final String dir, final String startWith, final String extension) {
        final File fileDir = new File(dir);
        if (!fileDir.isDirectory()) {
            return Optional.empty();
        }

        final File[] fileArrays = fileDir.listFiles();
        if (fileArrays == null || fileArrays.length == 0) {
            return Optional.empty();
        }

        return Optional.of(
                Arrays.stream(fileArrays)
                        .filter(d -> d.getName().startsWith(startWith))
                        .filter(d -> d.getName().endsWith(extension))
                        .collect(Collectors.toList())
        );
    }

}
