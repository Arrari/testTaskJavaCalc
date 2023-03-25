package org.MyApp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.File;
import org.apache.commons.lang3.math.NumberUtils;

public class Main  {
    private static boolean go;

    public static void main(String[] args) throws IOException{
        System.out.println("Welcome to my first calc!");
        System.out.println("To use it: enter your expression in 'a' 'operator' 'b' format");
        System.out.println("You can use arabic or roman style numbers, but not simultanoiusly.");
        System.out.println("To exit applet enter 'exit'");

        go = true;
        while (go) {
            String scannedString = StringFromConsole();
            String[] parsedStrings = StringParser(scannedString);
            System.out.println("You have entered: " + scannedString);
            if (CheckMemberType(parsedStrings[1])!= MemberType.OPERATOR) {
                throw new IOException("Wrong Input Format! Operation should be in the second place!");
            }
            if (CheckMemberType(parsedStrings[0])!= CheckMemberType(parsedStrings[2])) {
                throw new IOException("Wrong Input Format! You can not enter both Roman and Arabic numbers!");
            }


        }

    }

    public static String StringFromConsole(){
        String scannedString;
        Scanner scan = new Scanner(System.in);
        scannedString = scan.nextLine();
        if("exit".equals(scannedString)){
            go = false;
            System.out.println("You've entered 'exit'");
            System.out.println("App will be closed");
        }
        return scannedString;
    }
    public static String[] StringParser(String inputString) throws IOException{
        String[] parsedStringInput;
        parsedStringInput = inputString.split(" ");

        if (parsedStringInput.length!=3) {
            throw new IOException("Wrong Input Format! Expression cannot be longer than 3 members!");
        }
        return parsedStringInput;
    }
    public static MemberType CheckMemberType(String inputMember) {
        if (NumberUtils.isCreatable(inputMember)) {
        return org.MyApp.MemberType.INIT;}
        else if (("+".equals(inputMember))|("-".equals(inputMember))|("/".equals(inputMember))|("*".equals(inputMember))){
            return MemberType.OPERATOR;
        } else {
            return MemberType.ROMA;
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}