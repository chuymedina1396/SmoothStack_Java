// Create a Shape Interface with the methods "calculateArea" and "display". Create a Rectangle, Circle, and Triangle class to implement that interface. 

// UPDATED SOLUTION BELOW!

interface Shape{
    public double calculateArea();
    public double display();
}

public class AssignmentThree {
    public static void main(String[] args)
    {
        Shape rect = new Rectangle(2, 3);
        System.out.println("Area of rectangle: " + rect.display());

        Shape circle = new Circle(2);
        System.out.println("Area of circle: " + circle.display());

        Shape tri = new Triangle(2,3);
        System.out.println("Area of Triangle: " + tri.display());
    }

    //Made these shape classes below static so I can just reference them in my static main method :)

    public static class Rectangle implements Shape {
        int length, width;
        // constructor
        Rectangle(int length, int width) {
            this.length = length;
            this.width = width;
        }
        @Override 
        public double calculateArea(){
            return (double)(length * width);
        }
        public double display(){
            return calculateArea();
        }
    }
    public static class Circle implements Shape {
        double pi = 3.14;
        int radius;
        // constructor
        Circle(int radius){
            this.radius = radius;
        }
        @Override 
        public double calculateArea() {
            return (double)((pi * radius * radius) / 2);
        }
        @Override 
        public double display(){
            return calculateArea();
        }
    }
    public static class Triangle implements Shape {
        int base, height;
        // constructor
        Triangle(int base, int height){
            this.base = base;
            this.height = height;
        }
        @Override 
        public double calculateArea() {
            return (double)(base * height) / 2;
        }
        @Override 
        public double display(){
            return calculateArea();
        }
    }
}