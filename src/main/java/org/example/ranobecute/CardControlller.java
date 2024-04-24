package org.example.ranobecute;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

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
    void ClickMouse(MouseEvent event) {
        System.out.println("OKAY");
    }

    public void setData(Novel novel) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(novel.getImage());
        Image image = new Image(fileInputStream, 130, 180, false, false);
        NovelCover.setImage(image);
        NovelTitle.setText(novel.getTitle());
        NovelType.setText(novel.getType());
    }

    @FXML
    void initialize() {

    }

}
