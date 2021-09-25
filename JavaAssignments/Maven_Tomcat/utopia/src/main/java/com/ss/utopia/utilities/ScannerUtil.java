package com.ss.utopia.utilities;

import java.util.Scanner;

public class ScannerUtil {

    private ScannerUtil() {}

    static Scanner scan = new Scanner(System.in);

    public static String getStringInput(){
        String userInput = scan.nextLine();
        return userInput;
    }
    public static Integer getIntInput(){
        Integer userIntInput = scan.nextInt();
        return userIntInput;
    }

}
