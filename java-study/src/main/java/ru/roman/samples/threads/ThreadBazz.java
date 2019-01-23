/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.samples.threads;

/**
 * @author churganov_r 29.03.2011
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;
import java.util.Random;

class ThreadBazz extends JFrame implements Runnable {

    JTextField txt1 = new JTextField(10);
    JTextField txt2 = new JTextField(10);
    JTextField txtTime = new JTextField(19);
    int randValue = 0;
    long numbOfRand = 0;
    Thread sth = null;
    JButton sbtn;
    private boolean runFlag = false;

    ThreadBazz() {
        super("Знакомство с нитями (часы)");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        setSize(400, 300);
        Container c = getContentPane();
        JPanel pnm = new JPanel(new GridLayout(2, 1, 5, 5));
        c.add(pnm, BorderLayout.CENTER);
        JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JPanel pn2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnm.add(pn1);
        pnm.add(pn2);
        pn1.add(new JLabel("Номер числа        "));
        pn1.add(txt1);
        txt1.setEnabled(false);
        pn2.add(new JLabel("Случайное число"));
        pn2.add(txt2);
        txt2.setEnabled(false);
        JPanel pnb = new JPanel();
        JButton btn = new JButton("Показать число");
        pnb.add(btn);
        c.add(pnb, BorderLayout.SOUTH);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txt1.setText(String.valueOf(numbOfRand));
                txt2.setText(String.valueOf(randValue));
            }
        });
        JPanel pntop = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        sbtn = new JButton("Показать время");
        pntop.add(sbtn);
        pntop.add(txtTime);
        txtTime.setEnabled(false);
        txtTime.setEditable(false);
        c.add(pntop, BorderLayout.NORTH);
        sbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sth == null) {
                    sth = new Thread(ThreadBazz.this);
                    sth.start();
                }
                switchOnOff();
                sbtn.setText(isOn() ? "Остановить часы" : "Показать время");
            }
        });

        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);

        setVisible(true);

        Random rnd = new Random();
        for (; ; numbOfRand++) {
            randValue = rnd.nextInt();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void run() {
        while (true) {
            if (runFlag) {
                Date dt = new Date();
                txtTime.setText(dt.toString());
            } else {
                txtTime.setText("");
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }

    public boolean isOn() {
        return runFlag;
    }

    public void switchOnOff() {
        runFlag = !runFlag;
    }

    public static void main(String[] args) {
        new ThreadBazz();
    }
}
