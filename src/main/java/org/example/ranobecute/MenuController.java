package org.example.ranobecute;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MenuController {

    @FXML
    private ImageView logo;

    @FXML
    private ResourceBundle resources;


    @FXML
    private HBox CardLayoout;

    @FXML
    private URL location;

    @FXML
    private Button addNovel;



    @FXML
    void AddNewNovel(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) addNovel.getScene().getWindow();
        stage1.close();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addnovel.fxml"));

        loader.load();

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Adding a Novel | RanobeCute");
        stage.show();
    }
    @FXML
    void initialize() throws IOException, SQLException, ClassNotFoundException {
        DatabaseHandler dbhandler = new DatabaseHandler();

        ArrayList<Novel> recentlyAdded = new ArrayList<>(dbhandler.getAllNovel());

        for (int i = 0; i < recentlyAdded.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("card.fxml"));
            VBox cardBox = fxmlLoader.load();
            CardControlller cardControlller = fxmlLoader.getController();
            cardControlller.setData(recentlyAdded.get(i));
            CardLayoout.getChildren().add(cardBox);

        }
    }


}
