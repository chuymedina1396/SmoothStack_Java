// I was pretty lost on this one. Still researching Shape interfaces.

public interface Shape{
    
}

public class ShapeBase implements Shape {

    protected String name;
    protected int width, height;

    public ShapeBase(String name, int width, int height ){
        super();
        this.name = name;
        this.width = width;
        this.height = height;
    }
}

public class Rectangle extends ShapeBase {

}

public class Circle extends ShapBase {
    
}

public class Triangle extends ShapBase {
    public Triangle(String name, int width, int height ){
        super(name, width, height);
    }
    
}