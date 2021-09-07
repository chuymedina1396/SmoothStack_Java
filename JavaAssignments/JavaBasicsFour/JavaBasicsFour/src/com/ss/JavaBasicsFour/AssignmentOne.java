package com.ss.JavaBasicsFour;
// Created my Singleton called AssignmentOne.
public class AssignmentOne {
    //volatile tells jvm to not re-order instructions at line ten. Without this, a second thread can confuse the state OF instance and can mistakenly just return instance.
    private static volatile AssignmentOne instance = null;

    private AssignmentOne(){

    }

    public AssignmentOne getInstance(){
        // double checked locking from line 12-20.
        if(instance == null){   
            synchronized(this){
                if(instance == null){
                    instance = new AssignmentOne(); 
                }
            }

        }
        return instance;
    }
}