package org.example.ranobecute;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NovelPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label NovelAuthor;

    @FXML
    private ImageView NovelCover;

    @FXML
    private Label NovelDescription;

    @FXML
    private Label NovelGenre;

    @FXML
    private Label NovelStatus;

    @FXML
    private Label NovelTitle;

    @FXML
    private Label NovelType;

    @FXML
    private Label NovelYear;

    @FXML
    private ImageView logo;

    @FXML
    void LogoClicked(MouseEvent event) throws IOException {
        Stage stage1 = (Stage) logo.getScene().getWindow();
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
    void ReadNovel(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        try {
            DatabaseHandler dbHandler = new DatabaseHandler();
            Novel novel = dbHandler.getNovel(NovelTitle.getText());

            Stage stage1 = (Stage) NovelTitle.getScene().getWindow();
            stage1.close();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("read.fxml"));
            loader.load();
            ReadController readController = loader.getController();
            readController.setData(dbHandler.ReadChapter(String.valueOf(novel.getIdNovel())), novel.getTitle());
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(NovelTitle.getText() + " | RanobeCute");
            stage.show();
        }
        catch (Exception e ){
            System.out.println("Error");
        }
    }


    @FXML
    void AddChapterNovel(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) logo.getScene().getWindow();
        stage1.close();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addChapterNovel.fxml"));

        loader.load();

        AddChapterController addChapterController = loader.getController();
        addChapterController.setData(NovelTitle.getText());

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle( "Adding chapters | RanobeCute");
        stage.show();
    }


    @FXML
    void initialize() {
    }

    public void setData(Novel novel) throws FileNotFoundException {
        NovelTitle.setText(novel.getTitle());

        FileInputStream fileInputStream = new FileInputStream(novel.getImage());
        Image image = new Image(fileInputStream, 175, 255, false, false);
        NovelCover.setImage(image);
        NovelTitle.setText(novel.getTitle());
        NovelType.setText(novel.getType());
        NovelYear.setText(novel.getYear() + " г.");
        NovelStatus.setText(novel.getStatus());
        NovelGenre.setText(novel.getGenre());
        NovelDescription.setText(novel.getDescription());
        NovelAuthor.setText(novel.getAuthor());
    }

}
