package pl.ingobernable;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.net.URL;
import java.util.ResourceBundle;

public class GeneratorController implements Initializable {

    private final PasswordGenerator passwordGenerator;

    @FXML private  Spinner<Integer> spinner = new Spinner<>();

    @FXML private CheckBox upperCase = new CheckBox();
    @FXML private CheckBox digit = new CheckBox();
    @FXML private CheckBox specialSign = new CheckBox();

    @FXML private Button generate = new Button();
    @FXML private Button copy = new Button();

    @FXML private TextField passwordField = new TextField();
    @FXML private Label copyInfo = new Label();

    private boolean upperCaseFlag = false;
    private boolean digitFlag = false;
    private boolean specialSignFlag = false;



    public GeneratorController(){
        this(new PasswordGenerator());
    }

    public GeneratorController(PasswordGenerator passwordGenerator) {
        this.passwordGenerator = passwordGenerator;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> integer = new SpinnerValueFactory.IntegerSpinnerValueFactory(8,16);
        integer.setWrapAround(true);

        spinner.setValueFactory(integer);

        passwordField.setEditable(false);
    }

    @FXML void switchUpperCaseFlag() {
        upperCaseFlag = upperCase.isSelected();
    }

    @FXML void switchDigitFlag() {
        digitFlag = digit.isSelected();
    }

    @FXML void switchSpecialSignFlag() {
        specialSignFlag = specialSign.isSelected();
    }

    @FXML void generatePassword(){
        String password = passwordGenerator.generatePassword(spinner.getValue(), upperCaseFlag, digitFlag, specialSignFlag);
        passwordField.setText(password);

        copyInfo.setText("");
    }

    @FXML void addPasswordToClipboard(){
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(passwordField.getText());
        clipboard.setContent(content);

        copyInfo.setText("Copied to clipboard!");
    }
}
