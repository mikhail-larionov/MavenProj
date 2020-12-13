package ru.vsu.larionov.main.Main;

import ru.vsu.larionov.connection.Client;

import javax.swing.*;

public class Gui {
    JFrame jFrame;
    Client client;
    Gui(Client client){

    }
    public void init(){
        jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(0, 0, 1000, 700);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
