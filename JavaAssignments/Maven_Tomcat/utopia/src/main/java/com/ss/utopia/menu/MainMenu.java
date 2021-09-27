package com.ss.utopia.menu;

import com.ss.utopia.menu.admin.AdminMenu;
import com.ss.utopia.menu.employee.EmployeeMenu;

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
            + " 4) Quit" + newLine()
            );
            Integer selection = getIntInput();
            if(selection == 1){
                EmployeeMenu employeeMenu = new EmployeeMenu();
                employeeMenu.employeeMenuOption();
            }
            if(selection == 2) {
                AdminMenu adminMenu = new AdminMenu();
                adminMenu.adminMenuOptions();
            };
            // if(getIntInput() == 3){
            //     AdminMenu adminMenu = new AdminMenu();
            //     adminMenu.adminMenuOption();
            // };
            if(selection == 4) {
                System.out.println("Exiting Program...");
                System.exit(0);
            };
        // return "Welcome to the Utopia Airlines Managment System. Which category of a user are you: ";
    }
}
