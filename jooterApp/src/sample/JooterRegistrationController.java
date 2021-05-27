package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class JooterRegistrationController {

    boolean isDisabled;

    @FXML
    AnchorPane outerAnchorPane = new AnchorPane();
    @FXML
    TextField nameField = new TextField();
    @FXML
    TextField surnameField = new TextField();
    @FXML
    TextField loginField = new TextField();
    @FXML
    PasswordField passwordField = new PasswordField();
    @FXML
    TextField emailField = new TextField();
    @FXML
    Button submitButton = new Button();
    @FXML
    Label userExistsLabel = new Label();
    @FXML
    Button loginButton = new Button();
    @FXML
    Label invalidLoginLabel = new Label();
    @FXML
    Label invalidEmailLabel = new Label();
    @FXML
    Label invalidPasswordLabel = new Label();


    public void initialize(){

        submitButton.setDisable(true);
    }


    public void onTextFieldClicked(){

        invalidLoginLabel.setVisible(false);
        invalidPasswordLabel.setVisible(false);
        invalidEmailLabel.setVisible(false);

    }

    public void onKeyReleased(){

        String name = nameField.getText().trim();
        String surname = surnameField.getText().trim();
        String login = loginField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText().trim();
        isDisabled = name.isEmpty() || surname.isEmpty() || login.isEmpty() || email.isEmpty() || password.isEmpty();
        //isDisabled = ((name.isEmpty() || name.trim().isEmpty()) || (surname.isEmpty() || surname.trim().isEmpty()) || (login.isEmpty() || login.trim().isEmpty()) || (email.isEmpty() || email.trim().isEmpty()) || (password.isEmpty() || password.trim().isEmpty()));
        submitButton.setDisable(isDisabled);

    }


    public void onSubmitButtonClicked() {

        User user = new User();
        user.setUserName(nameField.getText().trim());
        user.setUserSurname(surnameField.getText().trim());
        user.setUserLogin(loginField.getText().trim());
        user.setUserPassword(passwordField.getText().trim());
        user.setUserEmail(emailField.getText().trim());
        user.setUserCardNo("1111111111111111");
        user.setUserAccountBalance(0.0);
        userExistsLabel.setVisible(false);

        boolean isLoginValid = Validate.validateUserLogin(loginField.getText().trim());
        boolean isEmailValid = Validate.validateEmail(emailField.getText().trim());
        boolean isPasswordValid = Validate.validateUserPassword(passwordField.getText().trim());
        boolean isRegistered = Registration.checkIfUserExists(user.getUserLogin(), user.getUserEmail());

        if (!isLoginValid) {

            submitButton.setDisable(true);
            invalidLoginLabel.setVisible(true);
            loginField.clear();

        } else {

            invalidLoginLabel.setVisible(false);
        }
        if (!isEmailValid) {

            invalidEmailLabel.setVisible(true);
            submitButton.setDisable(true);
            emailField.clear();

        } else {

            invalidEmailLabel.setVisible(false);
        }

        if (!isPasswordValid) {

            passwordField.clear();
            invalidPasswordLabel.setVisible(true);
            submitButton.setDisable(true);



        } else {

            invalidPasswordLabel.setVisible(false);
        }

        if (isLoginValid && isEmailValid && isPasswordValid) {

            if (!isRegistered) {

                Registration.registerUser(user);
                userExistsLabel.setText("Registration complete");
                userExistsLabel.setTextFill(Color.GREEN);
                userExistsLabel.setVisible(true);
                submitButton.setDisable(true);

            } else {
                userExistsLabel.setText("User already exists");
                userExistsLabel.setTextFill(Color.RED);
                submitButton.setDisable(true);
                userExistsLabel.setVisible(true);

            }

            nameField.clear();
            emailField.clear();
            surnameField.clear();
            passwordField.clear();
            nameField.clear();
            surnameField.clear();
            loginField.clear();
        }
    }

    public void onLoginButtonClicked(){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("JooterLogin.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            outerAnchorPane.getScene().getWindow().hide();

        }catch(IOException e){

            e.printStackTrace();
        }

    }

}
