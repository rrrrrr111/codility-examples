/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.jcl.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author дтоь 12.01.2008
 */
class HelloWorldActionListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        System.out.println(((HelloWorld.SpecJButton) e.getSource()).jBTextField.getText());
    }
}