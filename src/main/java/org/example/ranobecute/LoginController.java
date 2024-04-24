package org.example.ranobecute;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField usernameField;

    @FXML
    void Authorization(ActionEvent event) throws SQLException, IOException {
        String username = usernameField.getText().trim(); // trim() Delete space in text
        String password = passwordField.getText().trim();

        if( !username.equals("") && !password.equals("")){
            loginUser(username, password);
        }
        else
            System.out.println("Login and password is empty");
    }

    private void loginUser(String username, String password) throws SQLException, IOException {
        DatabaseHandler dbhandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        ResultSet result = dbhandler.getUser(user);

        int counter = 0;
        while( result.next() ){
            counter++;
            break;
        }
        if( counter == 1 ){
            System.out.println("Success!");
            Stage stage1 = (Stage) signUpButton.getScene().getWindow();
            stage1.close();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("menu.fxml"));

            loader.load();

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Menu | RanobeCute");
            stage.show();
        }
    }

    @FXML
    void switchToRegister(ActionEvent event) throws IOException {

        Stage stage1 = (Stage) signUpButton.getScene().getWindow();
        stage1.close();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("register.fxml"));

        loader.load();

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Registration | RanobeCute");
        stage.show();


    }

    @FXML
    void initialize() {

    }

}
