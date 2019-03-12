/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.jcl.swing.layout;

// LayoutExamples.java
// Визульное приложения с использованием различных Layout Manager'ов.

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class LayoutExamples extends JFrame {


    LayoutExamples() {
        super("Изучение концепции Layout Manager\'ов");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        setSize(400, 200);
        Container c = getContentPane();
        JTabbedPane tp = new JTabbedPane();
        c.add(tp, BorderLayout.CENTER);
        JPanel pn1 = new JPanel();
        addFields(pn1);
        tp.add(pn1, "FlowLayout");
        JPanel pn2 = new JPanel(new BorderLayout());
        tp.add(pn2, "BorderLayout");
        addBorderFields(pn2);
        JPanel pn3 = new JPanel(new GridLayout(3, 1, 0, 4));
        tp.add(pn3, "GridLayout");
        addFields(pn3);
        JPanel pn4 = new JPanel();
        BoxLayout bx = new BoxLayout(pn4, BoxLayout.Y_AXIS);
        pn4.setLayout(bx);
        addFields(pn4);
        tp.add(pn4, "BoxLayout-Y");


        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);

        setVisible(true);
    }

    private void addFields(JPanel pn) {
        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("Наименование");
        JTextField f1 = new JTextField(25);
        p1.add(l1);
        p1.add(f1);
        pn.add(p1);
        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Автор(ы)            ");
        JTextField f2 = new JTextField(25);
        p2.add(l2);
        p2.add(f2);
        pn.add(p2);
        JPanel p3 = new JPanel();
        JLabel l3 = new JLabel("Издательство  ");
        JTextField f3 = new JTextField(25);
        p3.add(l3);
        p3.add(f3);
        pn.add(p3);
    }

    private void addBorderFields(JPanel pn) {
        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("Наименование");
        JTextField f1 = new JTextField(25);
        p1.add(l1);
        p1.add(f1);
        pn.add(p1, BorderLayout.NORTH);
        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Автор(ы)            ");
        JTextField f2 = new JTextField(25);
        p2.add(l2);
        p2.add(f2);
        pn.add(p2, BorderLayout.CENTER);
        JPanel p3 = new JPanel();
        JLabel l3 = new JLabel("Издательство  ");
        JTextField f3 = new JTextField(25);
        p3.add(l3);
        p3.add(f3);
        pn.add(p3, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        LayoutExamples d = new LayoutExamples();
    }
}
