package com.greenjava.generics.upperbounded;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PersonLoader {

    private final RandomAccessFile file;

    public PersonLoader(File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "rw");
    }

    public Person load() throws IOException {

        return null;
    }
}
