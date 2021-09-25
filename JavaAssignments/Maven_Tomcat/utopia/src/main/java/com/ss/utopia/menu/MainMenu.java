package com.ss.utopia.menu;

import com.ss.utopia.menu.admin.AdminMenu;

import static com.ss.utopia.utilities.StringSeperatorUtil.newLine;

import java.sql.SQLException;

import static com.ss.utopia.utilities.ScannerUtil.getIntInput;


public class MainMenu {
    
    public static void getUserCategory() throws ClassNotFoundException, SQLException {
            System.out.println("Welcome to the Utopia Airlines Managment System. Which category of a user are you:" + newLine()
            + newLine()
            + " 1) Employee" + newLine()
            + " 2) Administrator" + newLine()
            + " 3) Traveler" + newLine()
            );
            Integer selection = getIntInput();
            // if(getIntInput() == 1){
            //     EmployeeMenu employeeMenu = new EmployeeMenu();
            //     employeeMenu.adminMenuOption();
            // };
            if(selection == 2) {
                AdminMenu adminMenu = new AdminMenu();
                adminMenu.adminMenuOptions();
            };
            // if(getIntInput() == 3){
            //     AdminMenu adminMenu = new AdminMenu();
            //     adminMenu.adminMenuOption();
            // };
        // return "Welcome to the Utopia Airlines Managment System. Which category of a user are you: ";
    }
}
