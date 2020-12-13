package ru.vsu.larionov.gui;

import java.util.Scanner;

public class Console {
    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Начало");
        System.out.println("Выберет действие");
        int x = scanner.nextInt();
        System.out.println("1 - войти \n 2 выйти");
        while (true){

            int k = scanner.nextInt();

        }
    }
}
