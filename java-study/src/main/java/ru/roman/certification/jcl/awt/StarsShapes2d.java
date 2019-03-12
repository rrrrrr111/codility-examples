/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.jcl.awt;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.GeneralPath;

/**
 * @author העמ
 */
class StarsShapes2d extends JFrame {

    StarsShapes2d() {
        getContentPane().setBackground(Color.gray);
    }

    public void paint(Graphics g) {
        super.paint(g);
        int xPoints[] = {55, 67, 109, 73, 83, 55, 27, 37, 1, 43};
        int yPoints[] = {0, 36, 36, 54, 96, 72, 96, 54, 36, 36};

        Graphics2D graphics2D = (Graphics2D) g;
        GeneralPath star = new GeneralPath();
        star.moveTo(xPoints[0] - 54, yPoints[0] - 54);

        for (int count = 1; count < xPoints.length; count++) {
            star.lineTo(xPoints[count] - 54, yPoints[count] - 54);
        }
        star.closePath();

        graphics2D.translate(200, 200);
        for (int count = 1; count <= 5; count++) {
            graphics2D.rotate(Math.PI / 20.0);
            graphics2D.setColor(new Color(
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256)));
            graphics2D.fill(star);
        }
    }

    public static void main(String args[]) {
        StarsShapes2d app = new StarsShapes2d();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(400, 400);
        app.setVisible(true);
    }
}
