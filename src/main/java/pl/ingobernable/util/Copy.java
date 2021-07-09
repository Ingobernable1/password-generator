package pl.ingobernable.util;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class Copy {

    public static void toClipboard(TextField passwordField, Label copyInfo){
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(passwordField.getText());
        clipboard.setContent(content);

        copyInfo.setText("Copied to clipboard!");
    }
}
