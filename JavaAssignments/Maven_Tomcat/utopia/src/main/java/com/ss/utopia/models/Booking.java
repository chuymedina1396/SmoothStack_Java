package com.ss.utopia.models;



import java.util.List;
import java.util.Objects;

public class Booking {
    private Integer bookingId;
    private Integer is_Active; 
    private String confirmationCode;
    private Flight flghtId;

    private List<FlightBooking> flightBookings;

    private List<Passenger> passengers;

    private BookingPayment bookingPayment;

    private BookingAgent bookingAgent;

    private BookingUser bookingUser;
 


    



    

}