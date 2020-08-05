package io;

import java.io.File;
import java.io.Serializable;

public class FileManager implements Serializable {
    private File file;
    private final String FILE_NAME;

    public FileManager(String fILE_NAME) {
        FILE_NAME = fILE_NAME;
        file = new File(FILE_NAME);
    }

    public boolean hasFile() {
        return file.exists();
    }

    public File loadFile() {
        return file;
    }
}
