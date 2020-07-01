package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Controller {

    @FXML
    private Rectangle background;

    @FXML
    private TextArea inputMessage;

    @FXML
    private Button sendButton;

    @FXML
    private TextArea messageScreen;

    @FXML
    private ImageView image;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private ColorPicker settings;

    @FXML
    private RadioButton imageRadioButton;

    @FXML
    private Button uploadButton;

    private String url;

    @FXML
    void sendMessage(ActionEvent event) throws IOException {
        try{

            ServerConnection serverConn = new ServerConnection(LoginPageController.getSocket(), messageScreen);
            PrintWriter stringToEcho = new PrintWriter(LoginPageController.getSocket().getOutputStream(), true);
            new Thread(serverConn).start();
            if (!inputMessage.getText().equals(""))
                stringToEcho.println(serverConn.getname() + ": " + inputMessage.getText());
            inputMessage.clear();
//            if (echoString.equalsIgnoreCase("exit")) break;

        }catch (IOException e){
            System.out.println("Client Error: " + e.getMessage());
        }
    }


    @FXML
    void changeBackgroundColor(ActionEvent event) {
        background.setFill(settings.getValue());
    }

    @FXML
    void selectFilesFromComputer(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose an Image File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.gif"));
        Stage stage = (Stage)anchorpane.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        url = file.getPath();
        System.out.println(url);
    }

    @FXML
    void upload(ActionEvent event) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(url);
        System.out.println(url);
        image.setImage(new Image(fis));
        image.setFitHeight(37);
        image.setFitWidth(39);
        image.setPreserveRatio(false);
    }
}
