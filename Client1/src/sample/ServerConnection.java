package sample;

import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerConnection extends Thread{
    private Socket server;
    private BufferedReader in;
    private PrintWriter out;
    //    private Image displayPicture = getImage("H:\\5th Semester\\Data Communication and Networks\\Java Network Programming\\First Client and Server\\Client\\src\\display picture.jpg");
    private String name;
    private TextArea messageScreen;

    public ServerConnection(Socket server, TextArea messageScreen) throws IOException {
        this.server = server;
        in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        out = new PrintWriter(server.getOutputStream(), true);
        this.name = LoginPageController.getName();
        this.messageScreen = messageScreen;
    }

    @Override
    public void run() {
        try {
                String serverResponse = in.readLine();
//                if (serverResponse == null) break;
                messageScreen.appendText(serverResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//            try {
////                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

    }
//    private static Image getImage(String address){
//        URL url = null;
//        try {
//            url = new URL(address);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        if (url != null){
//            ImageIcon icon = new ImageIcon(url);
//            return icon.getImage();
//        }else {
//            return null;
//        }
//    }

    public String getname() {
        return name;
    }

}
