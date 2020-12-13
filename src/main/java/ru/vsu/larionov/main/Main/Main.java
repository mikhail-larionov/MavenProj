package ru.vsu.larionov.main.Main;

//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.vsu.larionov.connection.Client;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;

public class Main extends Application {
    public static Client client;
    public static Controller controller;
    @Override
    public void start(Stage stage) throws IOException {
        URL url = new File("src/main/resources/sample.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage.setTitle("Train");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }



    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3345);
        Client client = new Client(socket);
        Main.client = client;
        launch();
    }

}
