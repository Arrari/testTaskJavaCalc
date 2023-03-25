package org.example;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Main  {
    public static void main(String[] args) {
        System.out.println("Welcome to my first calc!");
        System.out.println("To use it: enter your expression in 'a' 'operator' 'b' format");
        System.out.println("You can use arabic or roman style numbers, but not simultanoiusly.");
        System.out.println("To exit applet enter 'exit'");

        boolean go = true;
        while (go) {
            Scanner scan = new Scanner(System.in);
            String scannedString;
            clearScreen();
            scannedString = scan.nextLine();

            if("exit".equals(scannedString)){
                System.out.println("You've entered 'exit'");
                System.out.println("App will be closed");
                go = false;
            }


            System.out.println("You have entered: " + scannedString);
        }
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}