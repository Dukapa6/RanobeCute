package org.example.ranobecute;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton;

    @FXML
    private Button CreateAccountButton;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userNameField;

    @FXML
    void BackScene(ActionEvent event) throws IOException {
        SwitchToLogin();
    }

    @FXML
    void singUpButton(ActionEvent event) throws IOException {
        String username = userNameField.getText().trim(); // trim() Delete space in text
        String password = passwordField.getText().trim();
        String email = emailField.getText().trim();

        if( !username.equals("") && !password.equals("") && !email.equals("")){
            SignUpUser();
        }

    }

    private void SignUpUser() throws IOException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User(userNameField.getText(), passwordField.getText(), emailField.getText());

        dbHandler.signUpUser(user);
        SwitchToLogin();

    }

    private void SwitchToLogin() throws IOException {
        Stage stage1 = (Stage) BackButton.getScene().getWindow();
        stage1.close();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));

        loader.load();

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Login | RanobeCute");
        stage.show();
    }
    @FXML
    void initialize() {


    }

}
