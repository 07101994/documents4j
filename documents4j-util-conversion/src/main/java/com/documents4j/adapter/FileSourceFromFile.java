package com.documents4j.adapter;

import com.documents4j.api.IFileSource;
import com.google.common.base.Objects;

import java.io.File;

class FileSourceFromFile implements IFileSource {

    private final File file;

    public FileSourceFromFile(File file) {
        this.file = file;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public void onConsumed(File file) {
        /* do nothing */
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(FileSourceFromFile.class)
                .add("file", file)
                .toString();
    }
}
