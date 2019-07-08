package Shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Square implements Shape {
    private int y =(int) (500 * Math.random());
    private int x = (int) (500 * Math.random());
    @Override
    public String draw(Graphics e , Color c) {
        e.setColor(c);
        e.drawRect(getX(), getY(), 50, 50);
        return ShapeFactory.squ;
    }

    
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

}
