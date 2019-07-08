package Shapes;

public class ShapeFactory {

    public static final String cir = "Circle";
    public static final String squ = "Square";
    public static final String rec = "Rectangle";
    
    public static Shape MakeShape(String shape) {
        if (shape.equalsIgnoreCase(ShapeFactory.cir)) {
            return new Circle();
        } else if (shape.equalsIgnoreCase(ShapeFactory.rec)) {
            return new Rectangle();
        } else if (shape.equalsIgnoreCase(ShapeFactory.squ)) {
            return  new  Square();
        } else {
            return new Circle();
        }
    }
}
