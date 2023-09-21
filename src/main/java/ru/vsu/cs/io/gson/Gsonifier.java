package ru.vsu.cs.io.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.vsu.cs.io.FilePicker;
import ru.vsu.cs.io.FileReader;
import ru.vsu.cs.io.FileSaver;
import ru.vsu.cs.model.GameStartNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Gsonifier {

    private final String DEFAULT_FILEPATH = "src/main/resources/";
    private final String DEFAULT_FILENAME = "defaultSaveFile.save";
    private final Gson gson;
    private final FileSaver fileSaver;
    private final FilePicker filePicker;
    private final FileReader fileReader;

    public Gsonifier() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        fileSaver = new FileSaver();
        filePicker = new FilePicker();
        fileReader = new FileReader();
        checkDefaultSaveFileExists();
    }

    public void saveGameState(GameStartNode gameStartNode) {
        String filepath = String.format("%s%s", DEFAULT_FILEPATH, DEFAULT_FILENAME);
        saveGameStateToFile(gameStartNode, filepath);
    }

    public void saveGameStateToFile(GameStartNode gameStartNode, String filepath) {
        try {
            fileSaver.saveFile(gson.toJson(gameStartNode), filepath);
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }

    public GameStartNode readLastSavedGameState() {
        checkDefaultSaveFileExists();
        GameStartNode gameStartNode = null;
        try {
            String data = fileReader.readFile(DEFAULT_FILEPATH + DEFAULT_FILENAME);
            gameStartNode = gson.fromJson(data, GameStartNode.class);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File was not found");
        }
        return gameStartNode;
    }

    public GameStartNode readSavedGameStateFromFile() {
        GameStartNode gameStartNode = null;
        try {
            String filepath = filePicker.pickFile(DEFAULT_FILEPATH);
            if (filepath == null || filepath.isEmpty()) {
                filepath = DEFAULT_FILEPATH + DEFAULT_FILENAME;
            }
            String data = fileReader.readFile(filepath);
            gameStartNode = gson.fromJson(data, GameStartNode.class);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File was not found");
        } catch (IllegalStateException illegalStateException) {
            System.err.println("Wrong file content");
        }
        return gameStartNode;
    }

    private void createNewEmptySaveFile() {
        File file = new File(DEFAULT_FILEPATH + DEFAULT_FILENAME);
        try {
            file.createNewFile();
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }

    private void checkDefaultSaveFileExists() {
        File saveFile = new File(DEFAULT_FILEPATH + DEFAULT_FILENAME);
        if (!saveFile.exists()) {
            createNewEmptySaveFile();
        }
    }

    private boolean checkSaveFileIsEmptyOrIncorrect(String filepath) {
        try {
            String data = fileReader.readFile(filepath);
            return data.isEmpty() || gson.fromJson(data, GameStartNode.class) != null;
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File was not found");
            return true;
        }
    }
}
