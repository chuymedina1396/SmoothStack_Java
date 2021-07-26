// I was pretty lost on this one. Still researching Shape interfaces.
    //  UPDATE: Concept mastered. New to Java, sorry :)


// Create a Shape Interface with the methods "calculateArea" and "display". Create a Rectangle, Circle, and Triangle class to implement that interface. 

    // Your interface needs to declare the two methods specified in the requirements which is calculateArea and display. Then your classes that implement that interface should be overriding those methods. The calculateArea method should be calculating the area of each shape. The display method should be displaying the area that was calculated

interface Shape{
    void calculateArea();
    void display();
}

public class Rectangle implements Shape {
    public static void main(String[] args){
        
        @Override
        Reactange rectangle = new Reactangle();
        reactangle.display();
        rectangle.calculateArea();

    }
}
public class Circle implements Shape {
    public static void main(String[] args){
        @Override
        Circle circle = new Circle();
        circle.calculateArea();
        circle.display();
    }
}
public class Triangle implements Shape {
    public static void main(String[] args){
        @Override
        Triangle triangle = new Triangle();
        triangle.display();
        triangle.calculateArea();
    }
}
