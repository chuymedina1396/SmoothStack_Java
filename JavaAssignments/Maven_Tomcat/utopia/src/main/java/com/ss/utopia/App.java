package com.ss.utopia;

import java.sql.SQLException;

import com.ss.utopia.menu.MainMenu;

public class App 
{
    public static void main( String[] args ) {
        try{
            MainMenu.getUserCategory();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
}
