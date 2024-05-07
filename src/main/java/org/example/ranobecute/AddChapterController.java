package org.example.ranobecute;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddChapterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ChapterField;

    @FXML
    private TextArea ContentField;

    @FXML
    private Button CreateButton;

    @FXML
    private TextField NameField;

    @FXML
    private Label TitleName;

    @FXML
    private TextField VolumeField;

    @FXML
    private ImageView logo;

    @FXML
    void AddChapter(ActionEvent event) throws SQLException, ClassNotFoundException, IOException { // ChapterField ContentField NameField VolumeField

        if( !ChapterField.getText().trim().equals("") && !ContentField.getText().trim().equals("") && !NameField.getText().trim().equals("") &&
        !VolumeField.getText().trim().equals("") ){
            DatabaseHandler dbHandler = new DatabaseHandler();
            Novel novel = dbHandler.getNovel(TitleName.getText());
            new File("src/main/resources/ranoberead/" + novel.getTitle()).mkdirs();
            Chapter chapter = new Chapter(novel.getIdNovel(), Integer.valueOf(VolumeField.getText().trim()), Integer.valueOf(ChapterField.getText().trim()), NameField.getText(),
                    "src/main/resources/ranoberead/" + novel.getTitle() + "/Том " + VolumeField.getText().trim() + " Глава " + ChapterField.getText().trim()
                        + ".txt");
            FileWriter myWriter = new FileWriter("src/main/resources/ranoberead/" + novel.getTitle() + "/Том " + VolumeField.getText().trim() + " Глава " + ChapterField.getText().trim()
            + ".txt");
            myWriter.write(ContentField.getText());
            myWriter.close();
            dbHandler.CreateChapter(chapter);


            // Switch scene

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

    }

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

    public void setData(String title){
        TitleName.setText(title);
    }
    @FXML
    void initialize() {

    }

}
