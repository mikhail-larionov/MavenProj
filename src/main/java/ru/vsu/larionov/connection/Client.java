package ru.vsu.larionov.connection;

import ru.vsu.larionov.main.Main.Main;
import ru.vsu.larionov.Utils.Parser;

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
                    try {
                        String data = connection.receive();
                        Hangars hangars = Parser.hangarsParser(data);
                        Main.controller.update(hangars);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

        }).start();

    }
    public void sentMessageForAll(String string) throws IOException {
        connection.send(string);
        //todo shutdowh hook
    }
}
