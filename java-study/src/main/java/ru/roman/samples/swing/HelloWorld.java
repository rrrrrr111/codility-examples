package ru.roman.samples.swing;

import javax.swing.*;

public class HelloWorld extends JFrame {

    javax.swing.JLabel jLabel = null;
    javax.swing.JTextField jTextField = null;
    javax.swing.JButton jButton = null;

    public static void main(String[] args) {
        HelloWorld w = new HelloWorld();
        w.setVisible(true);
    }

    public HelloWorld() {
        super();
        this.setSize(300, 200);
        this.setLocation(100, 100);
        this.getContentPane().setLayout(null);
        this.add(getJLabel(), null);
        this.add(getJTextField(), null);
        this.add(getJButton(), null);
        this.setTitle("Hello World");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private javax.swing.JLabel getJLabel() {
        if (jLabel == null) {
            jLabel = new javax.swing.JLabel();
            jLabel.setBounds(34, 49, 53, 18);
            jLabel.setText("Name:");
        }
        return jLabel;
    }

    private javax.swing.JTextField getJTextField() {
        if (jTextField == null) {
            jTextField = new javax.swing.JTextField();
            jTextField.setBounds(96, 49, 160, 20);
        }
        return jTextField;
    }

    private javax.swing.JButton getJButton() {
        if (jButton == null) {
            jButton = new SpecJButton();
            jButton.setBounds(103, 110, 71, 27);
            jButton.setText("OK");
            jButton.addActionListener(new HelloWorldActionListener());
        }
        return jButton;


    }

    class SpecJButton extends JButton {
        JTextField jBTextField;

        SpecJButton() {
            super();
            jBTextField = jTextField;
        }
    }
}
