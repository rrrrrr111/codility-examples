/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.jcl.util.concurrent.app;

/**
 * @author העמ
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ticker extends Thread {

    private JButton b = new JButton("Toggle");
    private JTextField t = new JTextField(10);
    private int count = 0;
    private boolean runFlag = true;

    public Ticker(Container c) {
        b.addActionListener(new ToggleL());
        JPanel p = new JPanel();
        p.add(t);
        p.add(b);
        c.add(p);
    }

    class ToggleL implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            runFlag = !runFlag;
        }
    }

    public void run() {
        while (true) {
            if (runFlag) {
                t.setText(Integer.toString(count++));
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}

