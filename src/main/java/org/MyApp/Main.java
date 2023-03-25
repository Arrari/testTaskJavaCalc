package org.MyApp;

import java.io.IOException;
import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.StringUtils.*;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.math.NumberUtils.*;

public class Main  {
    private static boolean go;
    Integrals integral = new Integrals();


    public static void main(String[] args) throws IOException{
        System.out.println("Welcome to my first calc!");
        System.out.println("To use it: enter your expression in 'a' 'operator' 'b' format");
        System.out.println("You can use arabic or roman style numbers, but not simultanoiusly.");
        System.out.println("To exit applet enter 'exit'");
        go = true;
        while (go) {
          calc();
        }
    }

    public static void calc() throws IOException {
        String scannedString = StringFromConsole();
        String[] parsedStrings = StringParser(scannedString);
        System.out.println("You have entered: " + scannedString);
        if (CheckMemberType(parsedStrings[0])==memberType.NUMERIC) {
            Integrals.CalculacteInts(parsedStrings);
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
        String[] parsedStringOutput;
        parsedStringOutput = inputString.split(" ");

        if (parsedStringOutput.length!=3) {
            throw new IOException("Wrong Input Format! Expression should be in a (+,-,*,/) b format!");
        }
        if (CheckMemberType(parsedStringOutput[1])!= memberType.OPERATOR) {
            throw new IOException("Wrong Input Format! Operation (+,-,*,/) should be in the second place!");
        }
        if (CheckMemberType(parsedStringOutput[0])!= CheckMemberType(parsedStringOutput[2])) {
            throw new IOException("Wrong Input Format! Member Types is not comparable!");
        }

        return parsedStringOutput;
    }

    public static memberType CheckMemberType(String inputMember) {
        if (NumberUtils.isCreatable(inputMember)) {
        return memberType.NUMERIC;}
        else if (isOperation(inputMember)){
            return memberType.OPERATOR;
        } else {
            return memberType.ROMA;
        }
    }
    public static operationType OperationType(String inputString) throws IOException {
        switch (inputString) {
            case "+":
                return operationType.ADDITION;
            case "-":
                return operationType.SUSBSTRACTION;
            case "*":
                return operationType.MULTIPLICATION;
            case "/":
                return operationType.DIVISION;
            default:
                throw new IOException("Operation could not be recognised!");
        }
    }
    public static Boolean isOperation(String inputStringIsOperation) {
        if (("+".equals(inputStringIsOperation))|("-".equals(inputStringIsOperation))|("/".equals(inputStringIsOperation))|("*".equals(inputStringIsOperation))) {
            return true;
        } else {return false;}
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}