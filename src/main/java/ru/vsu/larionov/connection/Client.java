package ru.vsu.larionov.connection;

import ru.vsu.larionov.main.Main.Controller;
import ru.vsu.larionov.main.Main.Main;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private Integer hangarNumber = 1;
    Connection connection;
    private boolean isConnected = false;
    public Client (Socket socket) throws IOException {
        connection = new Connection(socket);
        isConnected = true;

        this.start();
    }
    public void start() throws IOException {
        System.out.println("Connected");
        receive();
    }

    private void receive() throws IOException {
        new Thread(() -> {
            while (true) {
                if (isConnected) {
                    String string = null;
                    try {
                        string = connection.receive();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (!string.isEmpty()) {

                        Main.controller.update(1, string);
                    }
                }
            }

        }).start();

    }
    public void sentMessageForAll(String string) throws IOException {
        connection.send(string);
    }
}
