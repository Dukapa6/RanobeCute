package org.example.ranobecute;


import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ReadController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ChapterTitle;

    @FXML
    private Label Content;

    @FXML
    private Label TitleName;

    @FXML
    private ImageView logo;

    @FXML
    void LogoClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {

    }

    public void setData( Chapter chapter, String title ) throws IOException {
        ChapterTitle.setText(chapter.getTitle());
        TitleName.setText(title);
        byte[] bytes = Files.readAllBytes(Paths.get(chapter.getPathtext()));
        String content = new String(bytes);
        Content.setText(content);
    }

}
