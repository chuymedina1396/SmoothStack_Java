package com.ss.utopia.utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;
import java.util.Random;



public class ScannerUtil {

    static final char[] CHARS = {'0','1', '2', '3', '4', '5', '6', '7', '8',  
    '9','a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',  
    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',  
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',  
    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };  

    static Random random = new Random(); 
    static Scanner scan = new Scanner(System.in);

    public static String getConfirmationCode() {  
        StringBuffer buffer = new StringBuffer();  
        for (int i = 0; i < 10; i++) { 
            buffer.append(CHARS[random.nextInt(CHARS.length)]);  
        }  
        return buffer.toString();  
    }  

    public static String getStringInput(){
        String userInput = scan.nextLine();
        scan.nextLine();
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
