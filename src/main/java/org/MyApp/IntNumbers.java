package org.MyApp;

import java.io.IOException;

import static org.apache.commons.lang3.math.NumberUtils.*;

class IntNumbers {
    public static void CalculateInts(String[] inputStrings) throws IOException {
        int firstMember =  toInt(inputStrings[0]);
        if ( !(0<= firstMember &&  firstMember <= 10 )) {throw new IOException("First Member is not in the [0:10] diapason!");}
        int secondMember = toInt(inputStrings[2]);
        if ( !(0<= secondMember && secondMember <= 10)) {throw new IOException("Second Member is not in the [0:10] diapason!");}
        try {
            operationType IntOperation = Main.OperationType(inputStrings[1]);
            MathHandler(firstMember,secondMember, IntOperation);
            PrintResault( MathHandler(firstMember,secondMember, IntOperation));
        } catch (IOException e) {
            throw new RuntimeException("Unknow Operation Type!");
        }

    }
    public static int MathHandler(int a, int b,operationType Operation) {
    switch (Operation){
        case ADDITION :
            return IntAddition(a,b);
        case SUSBSTRACTION:
            return IntSubstraction(a,b);
        case MULTIPLICATION:
            return IntMultiplication(a,b);
        case DIVISION:
            return IntDivision(a,b);
        default:
            return 0;
    }

    }
    public static int IntAddition(int a, int b) {
        return a+b;
    }
    public static int IntSubstraction(int a, int b) {
        return a-b;
    }
    public static int IntMultiplication(int a, int b) {
        return a*b;
    }
    public static int IntDivision(int a, int b) {
        if (b==0) {throw new ArithmeticException("Division by zero!");}
        else {return a/b;}
    }
    public static void PrintResault(int resault) {
        System.out.println(resault);
    }
}

