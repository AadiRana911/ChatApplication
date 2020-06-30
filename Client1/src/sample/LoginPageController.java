package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class LoginPageController {
    private static String name;
    @FXML
    private TextField nameField;
    private static Socket socket;
    @FXML
    void enterChatroom(ActionEvent event) throws IOException {
        socket = new Socket("localhost", 5000);
        if (nameField.getText() != null){
            name = nameField.getText();
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(root);

            Stage newStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            newStage.setScene(scene);
            newStage.show();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Enter a name first");
            alert.show();
        }

    }

    public static String getName() {
        return name;
    }

    public static Socket getSocket() {
        return socket;
    }
}
