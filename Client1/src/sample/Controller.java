package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Controller {

    @FXML
    private TextArea inputMessage;

    @FXML
    private Button sendButton;

    @FXML
    private TextArea messageScreen;

    @FXML
    private ImageView image;

    @FXML
    private RadioButton settings;

    @FXML
    private RadioButton imageRadioButton;

    @FXML
    private Button uploadButton;

    @FXML
    void sendMessage(ActionEvent event) throws IOException {
        try{

            ServerConnection serverConn = new ServerConnection(LoginPageController.getSocket(), messageScreen);
            PrintWriter stringToEcho = new PrintWriter(LoginPageController.getSocket().getOutputStream(), true);

            Scanner scan = new Scanner(System.in);
            String echoString;
            new Thread(serverConn).start();
            echoString = inputMessage.getText();
            stringToEcho.println(serverConn.getname() + ": " + echoString);
//            if (echoString.equalsIgnoreCase("exit")) break;

        }catch (IOException e){
            System.out.println("Client Error: " + e.getMessage());
        }
    }


    @FXML
    void changeBackgroundColor(ActionEvent event) {

    }

    @FXML
    void selectFilesFromComputer(ActionEvent event) {

    }

    @FXML
    void upload(ActionEvent event){
    }
}
