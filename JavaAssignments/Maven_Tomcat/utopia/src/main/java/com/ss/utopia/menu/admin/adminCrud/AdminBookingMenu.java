package com.ss.utopia.menu.admin.adminCrud;

// Packages
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

//Utilities
import static com.ss.utopia.utilities.ScannerUtil.*;
import static com.ss.utopia.utilities.StringSeperatorUtil.newLine;
import com.ss.utopia.utilities.ColorUtil;

// MENU
import com.ss.utopia.menu.admin.AdminMenu;

// MODELS
import com.ss.utopia.models.Booking;

// BRING IN ADMIN SERVICE BASE SERVICE METHODS FOR MOST DATABASE OPERATIONS
import com.ss.utopia.services.AdminService;


public class AdminBookingMenu extends ColorUtil {

    public void AdminBookingsStartMenu() throws ClassNotFoundException, SQLException {
        System.out.println( ANSI_GREEN + "Welcome Admin. What would you like to see:" + newLine()

        + "  1) Add Booking" + newLine()
        + "  2) Update Booking" + newLine()
        + "  3) Delete Booking" + newLine()
        + "  4) Read Booking" + newLine()
        + "  5) Quit to Previous Menu" + newLine()
    );

        Integer selection = getIntInput(); 
        AdminService adminService = new AdminService();
        
        if(selection == 1){
            System.out.println("Enter 0 for is_active, Enter 1 for not_active");
            Integer isActiveValue = getIntInput();
            String confirmationCode = getConfirmationCode();
            adminService.addBooking(isActiveValue, confirmationCode );
            AdminBookingsStartMenu();

        }
        if(selection == 2){
            System.out.println("Enter Booking Id to update Booking");
            Integer bookingId = getIntInput();
            System.out.println("Update the isActive column of that Booking. 0 for InActive, 1 for Active");
            Integer isActive  = getIntInput();
            adminService.updateBooking(bookingId, isActive);
            AdminBookingsStartMenu();
        }
        if(selection == 3){
            System.out.println("Enter Booking Id to delete");
            Integer bookingId = getIntInput();
            adminService.deleteBooking(bookingId);
            AdminBookingsStartMenu();
        }
        if(selection == 4) {
            System.out.println("1) Get all Bookings");
            System.out.println("2) Get Booking by Id");
            Integer optionId = getIntInput(); 
            if(optionId == 1){
                List<Booking> bookings = adminService.getAllBookings();
                for (Booking booking : bookings){ 
                    System.out.println("Reading Booking: " + newLine()
                        + ANSI_GREEN + booking.getBookingId() + " ) "
                        + ANSI_YELLOW + "Booking ID: " + booking.getBookingId() + " "
                        + booking.getIsActive()
                        + booking.getConfirmationCode()    
                    );
                }
                AdminBookingsStartMenu();
            }
            if(optionId == 2){
                System.out.println("Reading a booking");
                Integer bookingId = getIntInput();
                List<Booking> bookings = adminService.getBookingById(bookingId);
                for (Booking booking : bookings){
                    System.out.println("Reading Booking: " + newLine()
                        + ANSI_GREEN + booking.getBookingId() + " ) "
                        + ANSI_YELLOW + "Booking ID: " + booking.getBookingId()+ " "
                        + "IsActive: " + booking.getIsActive()
                        + "Confirmation Code" + booking.getConfirmationCode()
                    );
                }
                AdminBookingsStartMenu();
            } 
        }
        if(selection == 5){
           AdminMenu.adminMenuOptions();
        }
    }
}
