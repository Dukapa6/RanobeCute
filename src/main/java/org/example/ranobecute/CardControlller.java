package org.example.ranobecute;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CardControlller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView NovelCover;

    @FXML
    private Label NovelTitle;

    @FXML
    private Label NovelType;

    @FXML
    private VBox VBox;

    @FXML
    void ClickMouse(MouseEvent event) throws IOException, SQLException, ClassNotFoundException {
        Stage stage1 = (Stage) NovelTitle.getScene().getWindow();
        stage1.close();

        DatabaseHandler dbhandler = new DatabaseHandler();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Novel.fxml"));
        loader.load();
        NovelPageController novelPageController = loader.getController();
        novelPageController.setData(dbhandler.getNovel(NovelTitle.getText()));
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(NovelTitle.getText() + " | RanobeCute");
        stage.show();
    }

    public void setData(Novel novel) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(novel.getImage());
        Image image = new Image(fileInputStream, 120, 170, false, false);
        NovelCover.setImage(image);
        NovelTitle.setText(novel.getTitle());
        NovelType.setText(novel.getType());
    }

    @FXML
    void initialize() {

    }

}
