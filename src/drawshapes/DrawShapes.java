package drawshapes;

import Shapes.Circle;
import Shapes.Rectangle;
import Shapes.Shape;
import Shapes.ShapeFactory;
import Shapes.Square;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawShapes extends JFrame {

    JButton clear;
    JButton req;
    JButton cir;
    JButton squ;
    JButton undo;
    JPanel place;

    Stack<Shape> shapeStack = new Stack<>();

    public DrawShapes() throws HeadlessException {
        setTitle("Painter");
        setSize(600, 500);
        getContentPane().setBackground(Color.gray);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        req = new JButton("Rectangle");
        cir = new JButton("Circle");
        squ = new JButton("Square");
        clear = new JButton("Clear");
        undo = new JButton("Undo");

        req.addActionListener((ActionEvent e) -> {
            Graphics g = getGraphics();
            Shape rec = ShapeFactory.MakeShape(ShapeFactory.rec);
            rec.draw(g, Color.GREEN);
            shapeStack.push(rec);
            place.setSize(100, 200);
            place.setSize(10000, 200);
            undo.setVisible(true);
        });
        cir.addActionListener((ActionEvent e) -> {
            Graphics g = getGraphics();
            Shape cir1 = ShapeFactory.MakeShape(ShapeFactory.cir);
            cir1.draw(g, Color.CYAN);
            shapeStack.push(cir1);
            place.setSize(100, 200);
            place.setSize(10000, 200);
            undo.setVisible(true);
        });

        squ.addActionListener((ActionEvent e) -> {
            Graphics g = getGraphics();
            Shape squ1 = ShapeFactory.MakeShape(ShapeFactory.squ);
            squ1.draw(g, Color.YELLOW);
            shapeStack.push(squ1);
            place.setSize(100, 200);
            place.setSize(10000, 200);
            undo.setVisible(true);
        });

        clear.addActionListener((ActionEvent e) -> {
            setSize(500, 400);
            setSize(600, 500);
            shapeStack.removeAllElements();
            undo.setVisible(false);
        });

        undo.addActionListener((ActionEvent e) -> {
            Graphics g = getGraphics();
            Shape undoShape = shapeStack.pop();
            String type = undoShape.draw(g, Color.gray);
            switch (type) {
                case ShapeFactory.cir:
                    Circle c = (Circle) undoShape;
                    undoShape.draw(g, Color.gray);

                    break;

                case ShapeFactory.rec:
                    Rectangle r = (Rectangle) undoShape;
                    undoShape.draw(g, Color.gray);
                    break;

                default:
                    Square s = (Square) undoShape;
                    undoShape.draw(g, Color.gray);
                    break;
            }
            if (shapeStack.empty()) {
                undo.setVisible(false);
            }
            place.setSize(100, 200);
            place.setSize(10000, 200);
            place.setBackground(Color.lightGray);

        });
        place = new JPanel(new FlowLayout());
        place.add(req);
        place.add(new JLabel(" "));
        place.add(cir);
        place.add(new JLabel(" "));
        place.add(squ);
        place.add(new JLabel(" "));
        place.add(clear);
        place.add(new JLabel(" "));
        place.add(undo);
        place.setBackground(Color.LIGHT_GRAY);
        add(place);
        add(BorderLayout.SOUTH, place);
        setDefaultCloseOperation(NORMAL);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Yes", "No"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Are you sure you want to exit?", "Online Examination System",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    System.exit(0);
                }
            }
        });

        undo.setVisible(false);
        setVisible(true);
        setResizable(false);

    }

    public static void main(String[] args) {
        new DrawShapes();
    }

}
