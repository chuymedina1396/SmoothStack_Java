package com.utopia;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you?");
        System.out.println("1) Employee/Agent");
        System.out.println("2) Administrator");
        System.out.println("3) Traveler");
        String input = scan.nextLine();
        if(input == "1"){
            System.out.println("You have chosen Employee and will now be directed to the Employee Menu");
        }
        if(input == "2"){
            System.out.println("You have chosen Administrator and will now be directed to the Administrator Menu");
        }
        if(input == "3"){
            System.out.println("You have chosen Traveler and will now be directed to the Traveler Menu");
        }
    }
}
