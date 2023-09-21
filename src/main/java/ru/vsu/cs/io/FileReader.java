package ru.vsu.cs.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public String readFile(String filepath) throws FileNotFoundException {
        File file = new File(filepath);
        Scanner fileScanner = new Scanner(file);
        StringBuilder data = new StringBuilder();
        while (fileScanner.hasNextLine()) {
            data.append(fileScanner.nextLine());
        }
        fileScanner.close();
        return data.toString();
    }
}
