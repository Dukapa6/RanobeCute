package org.example.ranobecute;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;

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

        // Socket and Threads

        try{
            Socket socket = new Socket("127.0.0.1", 444);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            outputStream.writeObject(new String[]{"Login",username,password} );
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            String s = (String) inputStream.readObject();
            if( s.equals("1") ){
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
        }catch (Exception e){
            System.out.println("Eror connection!");
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
