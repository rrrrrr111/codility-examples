/*
 * Created on 28.11.2009, 12:51:01
 */
package ru.roman.samples.crypto;

import javax.swing.*;

/**
 * @author העמ
 */
class EncryptDecryptApplet extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init() {
        getContentPane().add(new EncryptDecrypt().jPanel1);
    }
    // TODO overwrite start(), stop() and destroy() methods
}
