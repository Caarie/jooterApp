package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    boolean isDisabled;
    private static int userID;
    Parent root;
    Stage stage = new Stage();


    @FXML
    AnchorPane outerAnchorPane = new AnchorPane();
    @FXML
    Button loginButton = new Button();
    @FXML
    Button createAccButton = new Button();
    @FXML
    PasswordField passwordField = new PasswordField();
    @FXML
    TextField loginField = new TextField();
    @FXML
    Label passwordLabel = new Label();
    @FXML
    Label invalidInfoLabel = new Label();
    @FXML
    CheckBox checkBox = new CheckBox();


    public void onCreateAccButtonClicked() {

        try {
            root = FXMLLoader.load(getClass().getResource("jooterRegistration.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
            outerAnchorPane.getScene().getWindow().hide();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void initialize() {

        loginButton.setDisable(true);
        try (BufferedReader br = new BufferedReader(new FileReader("checkbox.txt"))) {

            String isSelected = br.readLine();
            if (isSelected.equals("selected")) {

                checkBox.setSelected(true);

                int id = Integer.parseInt(br.readLine());
                try (ResultSet rs = DataSource.getInstance().queryUser(id)) {

                    while (rs.next()) {
                        passwordField.setText(rs.getString(DataSource.getColumnUserPassword()));
                        loginField.setText(rs.getString(DataSource.getColumnUserLogin()));
                        loginButton.setDisable(false);

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getUserID() {
        return userID;
    }

    public void onLoginButtonClicked() {

        String login = loginField.getText().trim();
        String password = passwordField.getText().trim();
        int loginCheck = Login.CheckLogin(login, password);

        if (loginCheck != 0) {

            if (loginCheck > 0) {

                try {

                    root = FXMLLoader.load(getClass().getResource("UserScooterDisplay.fxml"));
                    userID = Login.CheckLogin(login, password);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {

                try {
                    root = FXMLLoader.load(getClass().getResource("JooterAdminPanel.fxml"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            stage.setScene(new Scene(root));
            stage.show();
            outerAnchorPane.getScene().getWindow().hide();
            if (checkBox.isSelected()) {
                try (BufferedWriter bf = new BufferedWriter(new FileWriter("checkbox.txt"))) {

                    bf.write("selected");
                    bf.newLine();
                    bf.write(String.valueOf(userID));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            invalidInfoLabel.setVisible(true);
            passwordField.clear();
            loginField.clear();
        }

    }

    public void onTextFieldClicked() {

        invalidInfoLabel.setVisible(false);

    }


    public void onKeyReleased() {

        String login = loginField.getText().trim();
        String password = passwordField.getText().trim();
        //isDisabled = ((login.isEmpty() || login.trim().isEmpty()) || (password.isEmpty() || password.trim().isEmpty()));
        isDisabled = login.isEmpty() || password.isEmpty();
        loginButton.setDisable(isDisabled);

    }


}
