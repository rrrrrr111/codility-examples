/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.jcl.util.concurrent.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author העמ
 */
class Counter extends JApplet {

    private JButton start = new JButton("Start");
    private boolean started = false;
    private Ticker[] s;
    private boolean isApplet = true;
    private int size;

    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        // Get parameter "size" from Web page:
        if (isApplet) {
            size =
                    Integer.parseInt(getParameter("size"));
        }
        s = new Ticker[size];
        for (int i = 0; i < s.length; i++) {
            s[i] = new Ticker(cp);
        }
        start.addActionListener(new StartL());
        cp.add(start);
    }

    class StartL implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (!started) {
                started = true;
                for (int i = 0; i < s.length; i++) {
                    s[i].start();
                    if (i == 0) s[i].setPriority(Thread.MAX_PRIORITY);
                    if (i == 1) s[i].setPriority(Thread.MIN_PRIORITY);
                }
            }
        }
    }

    public static void main(String[] args) {
        Counter applet = new Counter();
        // This isn't an applet, so set the flag and
        // produce the parameter values from args:
        applet.isApplet = false;
        applet.size =
                (args.length == 0 ? 5 : Integer.parseInt(args[0]));
        JFrame frame = new JFrame("Counter");
        frame.addWindowListener(
                new WindowAdapter() {

                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
        frame.getContentPane().add(applet);
        frame.setSize(200, applet.size * 50 + 30);
        applet.init();
        applet.start();
        frame.setVisible(true);
    }
}
