package pl.ingobernable;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.ingobernable.util.Copy;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ValidatorController implements Initializable {

    @FXML CheckBox uppercaseLetter = new CheckBox();
    @FXML CheckBox digit = new CheckBox();
    @FXML CheckBox specialSign = new CheckBox();

    @FXML TextField textField = new TextField();

    @FXML Button validateButton = new Button();
    @FXML Button copy = new Button();
    @FXML Button nextMode = new Button();

    @FXML Label validationLabel = new Label();
    @FXML Label copyInfo = new Label();

    private final PasswordValidator validator;

    public ValidatorController(){
        this(new PasswordValidator());
    }

    ValidatorController(PasswordValidator validator) {
        this.validator = validator;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML void validate(){

        boolean result = validator.isPasswordValid(textField.getText(), uppercaseLetter.isSelected(), digit.isSelected(), specialSign.isSelected());

        if (result)
            validationLabel.setText("Password is correct and relative to the current criteria.");
        else
            validationLabel.setText("Password is invalid.");
    }

    @FXML void goToTheGeneratePasswordMode() throws IOException {
        App.setRoot("generator");
    }

    @FXML void addPasswordToClipboard(){
        Copy.toClipboard(textField, copyInfo);
    }
}
