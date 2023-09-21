package ru.vsu.cs.io;


import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {

    public void saveFile(String json, String filepath) throws IOException {
        FileWriter writer = new FileWriter(filepath);
        writer.write(json);
        writer.close();
    }
}
