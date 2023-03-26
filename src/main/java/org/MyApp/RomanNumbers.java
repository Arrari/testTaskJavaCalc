package org.MyApp;

import java.io.IOException;
import java.util.*;

import static org.MyApp.IntNumbers.MathHandler;
import static org.MyApp.IntNumbers.PrintResault;

class RomanNumbers {
    public static void CalculateRomans (String[] inputStrings) throws IOException {
        int firstNumber = RomanToInt(inputStrings[0]);
        int secondNumber = RomanToInt(inputStrings[2]);
        if ( !(0<= firstNumber &&  firstNumber <= 10 )) {throw new IOException("First Member is not in the [0:10] diapason!");}
        if ( !(0<= secondNumber && secondNumber <= 10)) {throw new IOException("Second Member is not in the [0:10] diapason!");}
        try {
            operationType IntOperation = Main.OperationType(inputStrings[1]);
            PrintRomanResault(IntToRoman(MathHandler(firstNumber,secondNumber, IntOperation)));
        } catch (IOException e) {
            throw new RuntimeException("Unknow Operation Type!");
        }

    }
    public static int RomanToInt(String stringToConvert) throws IOException {
        Map<Character,Integer> numbersMap = new HashMap<>();
        numbersMap.put('I',1);
        numbersMap.put('V',5);
        numbersMap.put('X',10);
        numbersMap.put('L',50);
        numbersMap.put('C',100);
        numbersMap.put('D',500);
        numbersMap.put('M',1000);

        int result = 0;
        stringToConvert = stringToConvert.toUpperCase(Locale.ROOT);
        for(int i=0 ; i<stringToConvert.length(); i++ ) {
            char ch = stringToConvert.charAt(i);
            if (!(numbersMap.containsKey(ch))) {throw new IOException("Wrong Roman Number Input Format! Inputed key doesn't supported!");}
            if (i>0 && numbersMap.get(ch) > numbersMap.get(stringToConvert.charAt(i-1))){
                result += numbersMap.get(ch) - 2*numbersMap.get(stringToConvert.charAt(i-1));
            } else result+= numbersMap.get(ch);

        }
        return result;
    }
    public static void PrintRomanResault(String resault) {
        System.out.println(resault);
    }

    public static String IntToRoman(int intToConvert) {
        if (intToConvert<=0) {throw new ArithmeticException("Resulting roman number cannot be less or equal zero!");}
        int[] intNumbers = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String romanNums[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        String romanResault = "";
        while (intToConvert > 0) {
            int currentMax = 0;
            for (int i=0; i<intNumbers.length; i++) {
                if (intToConvert >= intNumbers[i]) {
                    currentMax = i;
                }
            }
            romanResault+= romanNums[currentMax];
            intToConvert-=intNumbers[currentMax];
        }
        return romanResault;
    }

}
