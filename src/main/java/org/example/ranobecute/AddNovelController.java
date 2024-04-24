package org.example.ranobecute;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.imageio.ImageIO;

public class AddNovelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AuthorField;

    @FXML
    private Button CreateButton;

    @FXML
    private ImageView Image;

    @FXML
    private TextArea DescriptionField;

    @FXML
    private TextField GenreField;

    @FXML
    private Button ImageButton;

    @FXML
    private ComboBox<String> StatusComboBox;

    @FXML
    private TextField TitleField;

    @FXML
    private ComboBox<String> TypeComboBox;

    @FXML
    private TextField YearField;

    @FXML
    void LogoClicked(MouseEvent event) throws IOException {
        Stage stage1 = (Stage) CreateButton.getScene().getWindow();
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

    @FXML
    void FileChooser(ActionEvent event) throws IOException {

        Stage stage = (Stage) ImageButton.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.webp"));
        fileChooser.setTitle("Open");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            Image img = new Image(file.toURI().toString());
            Image.setImage(img);
            File save = new File("src/main/resources/ranobeimg/image.png");
            SwingFXUtils SwingFXUtils = null;
            ImageIO.write(SwingFXUtils.fromFXImage(Image.getImage(), null), "png", save);
        }
    }


    @FXML
    void CreateNovel(ActionEvent event) throws IOException {
        if( !TitleField.getText().equals("") && !AuthorField.getText().equals("") && !TypeComboBox.getSelectionModel().getSelectedItem().equals("null")
            && !StatusComboBox.getSelectionModel().getSelectedItem().equals("null") && !YearField.getText().equals("") && !GenreField.getText().equals("") &&
                !DescriptionField.getText().equals("")){
            File save = new File("src/main/resources/ranobeimg/" + TitleField.getText().trim() + ".png");
            SwingFXUtils SwingFXUtils = null;
            ImageIO.write(SwingFXUtils.fromFXImage(Image.getImage(), null), "png", save);
            DatabaseHandler dbHandler = new DatabaseHandler();
            Novel novel = new Novel(TitleField.getText(), AuthorField.getText(), GenreField.getText(), DescriptionField.getText(),
                    StatusComboBox.getSelectionModel().getSelectedItem(), "src/main/resources/ranobeimg/" + TitleField.getText() + ".png",
                    TypeComboBox.getSelectionModel().getSelectedItem(), YearField.getText());
            dbHandler.CreateNovel(novel);
        }
    }

    @FXML
    void initialize() { // TypeComboBox.getSelectionModel().getSelectedItem()

        String[] items = {"Japan", "Korea", "China", "English", "Authorial", "FanFiction"};
        TypeComboBox.getItems().addAll(items);

        String[] items1 = {"Ongoing", "Completed", "Announcement", "Paused", "Stopped"};
        StatusComboBox.getItems().addAll(items1);

    }

}
