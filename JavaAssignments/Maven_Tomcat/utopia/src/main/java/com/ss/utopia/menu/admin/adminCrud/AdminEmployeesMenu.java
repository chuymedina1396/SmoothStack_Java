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

public class AdminEmployeesMenu extends ColorUtil {

    public static void EmployeesStartMenu() throws ClassNotFoundException, SQLException {
        System.out.println( ANSI_GREEN + "Welcome Admin. What would you like to see:" + newLine()

        + "  1) Add Employee" + newLine()
        + "  2) Update Employee" + newLine()
        + "  3) Delete Employee" + newLine()
        + "  4) Read Employee" + newLine()
        + "  5) Quit to Previous Menu" + newLine()
    );

        Integer selection = getIntInput(); 

        if(selection == 1){
            AdminService adminService = new AdminService();
            // System.out.println("Enter 0 for is_active, Enter 1 for not_active");
            // Integer isActiveValue = getIntInput();
            // String confirmationCode = getConfirmationCode();
            // adminService.addUser(isActiveValue, confirmationCode );
            EmployeesStartMenu();

        }
        // if(selection == 2){
        //     AdminService adminService = new AdminService();
        //     System.out.println("Enter Employee Id to update Employee");
        //     Integer employeeId = getIntInput();
        //     System.out.println("Update the Employee Id of that Employee.");
        //     Integer employeeId  = getIntInput();
        //     adminService.updateUser(employeeId, employeeId);
        //     EmployeesStartMenu();
        // }
        // if(selection == 3){
        //     AdminService adminService = new AdminService();
        //     System.out.println("Enter Employee Id to delete");
        //     Integer employeeId = getIntInput();
        //     adminService.deleteUser(employeeId);
        //     EmployeesStartMenu();
        // }
        // if(selection == 4) {
        //     System.out.println("1) Get all Users");
        //     System.out.println("2) Get Employee by Id");
        //     Integer optionId = getIntInput(); 
        //     AdminService adminService = new AdminService();
        //     if(optionId == 1){
        //         List<User> employees = adminService.getAllUsers();
        //         for (User employee : employees){  // Which you iterate 
        //             System.out.println("Reading Employee: " + newLine()
        //                 + ANSI_GREEN + employee.getUserId() + " ) "
        //                 + ANSI_YELLOW + "Given Name: " + employee.getGivenName() + " "
        //                 + "FamilyName: " + employee.getFamilyName() + " "
        //                 + "Gender: " + employee.getGender()
        //                 + "Address: " + employee.getAddress() + newLine()
        //                 + "Employee Object: " + employee.getUserId()
                        
        //             );
        //         }
        //         EmployeesStartMenu();
        //     }
        //     if(optionId == 2){
        //         System.out.println("Enter a Employee Id to read that entry.");
        //         Integer employeeId = getIntInput();
        //         List<Employee> employees = adminService.getUserById(employeeId);
        //         for (Employee employee : employees){  // Which you iterate 
        //             System.out.println("Reading Employee: " + newLine()
        //                 + ANSI_GREEN + employee.getUserId() + " ) "
        //                 + ANSI_YELLOW + "Given Name: " + employee.getGivenName() + " "
        //                 + "FamilyName: " + employee.getFamilyName() + " "
        //                 + "Gender: " + employee.getGender()
        //                 + "Address: " + employee.getAddress() + newLine()
        //                 + "Employee Object: " + employee.getUserId() 
        //             );
        //         }
        //         EmployeesStartMenu();
        //     } 
        // }
        if(selection == 5){
           AdminMenu.adminMenuOptions();
        }
    }
}
