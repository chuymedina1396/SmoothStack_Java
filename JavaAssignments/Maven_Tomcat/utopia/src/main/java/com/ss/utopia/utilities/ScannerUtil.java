package com.ss.utopia.utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.GregorianCalendar;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class ScannerUtil {

    static Scanner scan = new Scanner(System.in);

    public static String getStringInput(){
        scan.nextLine();
        String userInput = scan.nextLine();
        return userInput;
    }
    public static Integer getIntInput(){
        Integer userIntInput = scan.nextInt();
        return userIntInput;
    }
    public static Float getFloatInput(){
        Float userIntInput = scan.nextFloat();
        return userIntInput;
    }
    public static String getDateInput(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Before Formatting: " + now);  
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        String formatDateTime = now.format(formatter); 
        return formatDateTime;
    }
    

}
