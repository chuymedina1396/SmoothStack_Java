package com.ss.utopia.menu.admin.adminCrud;

import java.sql.Date;
import java.sql.SQLException;

//Utilities
import static com.ss.utopia.utilities.ScannerUtil.*;


import static com.ss.utopia.utilities.StringSeperatorUtil.newLine;
import java.util.List;

import com.ss.utopia.menu.admin.AdminMenu;
import com.ss.utopia.models.User;
import com.ss.utopia.services.AdminService;
import com.ss.utopia.utilities.ColorUtil;

public class AdminTravellersMenu extends ColorUtil {

    public static void TravellersStartMenu() throws ClassNotFoundException, SQLException {
        System.out.println( ANSI_GREEN + "Welcome Admin. What would you like to see:" + newLine()

        + "  1) Add Traveller" + newLine()
        + "  2) Update Traveller" + newLine()
        + "  3) Delete Traveller" + newLine()
        + "  4) Read Traveller" + newLine()
        + "  5) Quit to Previous Menu" + newLine()
    );

        Integer selection = getIntInput(); 

        if(selection == 1){
            AdminService adminService = new AdminService();
            System.out.println("Enter 0 for is_active, Enter 1 for not_active");
            Integer isActiveValue = getIntInput();
            String confirmationCode = getConfirmationCode();
            // adminService.addUser();
            TravellersStartMenu();

        }
        // if(selection == 2){
        //     AdminService adminService = new AdminService();
        //     System.out.println("Enter Employee Traveller Id to update Traveller");
        //     Integer employeesUserId = getIntInput();
        //     System.out.println("Update the Traveller Id of that Traveller.");
        //     Integer employeesUserId  = getIntInput();
        //     adminService.updateUser(employeesUserId, employeesUserId);
        //     TravellersStartMenu();
        // }
        // if(selection == 3){
        //     AdminService adminService = new AdminService();
        //     System.out.println("Enter Traveller Id to delete");
        //     Integer employeesUserId = getIntInput();
        //     adminService.deleteUser(employeesUserId);
        //     TravellersStartMenu();
        // }
        // if(selection == 4) {
        //     System.out.println("1) Get all Traveller Users");
        //     System.out.println("2) Get Traveller by ID");
        //     Integer optionId = getIntInput(); 
        //     AdminService adminService = new AdminService();
        //     if(optionId == 1){
        //         List<Traveller> employeesUsers = adminService.getAllUsers();
        //         for (Traveller employeesUser : employeesUsers){  // Which you iterate 
        //             System.out.println("Reading Traveller: " + newLine()
        //                 + ANSI_GREEN + employeesUser.getUserId() + " ) "
        //                 + ANSI_YELLOW + "Given Name: " + employeesUser.getGivenName() + " "
        //                 + "FamilyName: " + employeesUser.getFamilyName() + " "
        //                 + "Gender: " + employeesUser.getGender()
        //                 + "Address: " + employeesUser.getAddress() + newLine()
        //                 + "Traveller Object: " + employeesUser.getUserId()
                        
        //             );
        //         }
        //         TravellersStartMenu();
        //     }
        //     if(optionId == 2){
        //         System.out.println("Enter a Flight Id to read that entry.");
        //         Integer employeesUserId = getIntInput();
        //         List<Traveller> employeesUsers = adminService.getUserById(employeesUserId);
        //         for (Traveller employeesUser : employeesUsers){  // Which you iterate 
        //             System.out.println("Reading Traveller: " + newLine()
        //                 + ANSI_GREEN + employeesUser.getUserId() + " ) "
        //                 + ANSI_YELLOW + "Given Name: " + employeesUser.getGivenName() + " "
        //                 + "FamilyName: " + employeesUser.getFamilyName() + " "
        //                 + "Gender: " + employeesUser.getGender()
        //                 + "Address: " + employeesUser.getAddress() + newLine()
        //                 + "Traveller Object: " + employeesUser.getUserId() 
        //             );
        //         }
        //         TravellersStartMenu();
        //     } 
        // }
        if(selection == 5){
           AdminMenu.adminMenuOptions();
        }
    }
}
