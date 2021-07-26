// An Interface is the outline FOR a class


// interface give details to the class that is IMPLEMENTING IT.
    // create an outline of the class basically.

import java.util.List;
import java.util.Arrays;

interface WaterBottleInterface {

    // These are the attributes for the class

    String color = "Blue";

    void fillUp();

    List <Integer> arr = Arrays.asList(1,2,3,4,5);

    String name = "Jesus Medina";

}

// implments keyword delcares the class to us the WaterBottleInterface
public class InterfaceExample implements WaterBottleInterface{
    public static void main(String[] args){
        // Everything in the interface has to be in the class.
            // So you have to use the color varbiable and the fillUp method below cause it's in the interface.
        System.out.println(color);
        // Create a new instance of this class, which is called InterfaceExample
        InterfaceExample ex = new InterfaceExample();
        //use your 'ex' variable to invoke the fillUp method.
        for(int i =0; i<arr.size(); i++){
            System.out.println(i);
        }
        ex.fillUp();
        

    }

    @Override
    public void fillUp() {
        // TODO Auto-generated method stub
        System.out.println("It was filled");

        
    }
}