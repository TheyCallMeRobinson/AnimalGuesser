package ru.vsu.cs.io;

import javax.swing.*;
import java.io.File;

public class FilePicker {

    public String pickFile(String defaultDirectory) {
        // https://stackoverflow.com/a/16764736
        JFileChooser chooser = new JFileChooser(defaultDirectory);
        int status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (file == null) {
                return null;
            }
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
}
