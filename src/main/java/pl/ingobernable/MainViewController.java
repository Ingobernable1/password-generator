package pl.ingobernable;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML void enterInValidateMode() throws IOException {
        App.setRoot("validator");
    }

    @FXML void enterInGenerateMode() throws IOException {
        App.setRoot("generator");
    }
}
