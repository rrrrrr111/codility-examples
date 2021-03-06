/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IoApp.java
 *
 * Created on 22.09.2009, 9:50:01
 */

package ru.roman.jcl.io;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * @author Роман 20.01.2008 JDK 1.5
 */
class IoApp extends javax.swing.JFrame {

    /**
     * Creates new form IoApp
     */
    public IoApp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToggleButton1.setText("jToggleButton1");
        jToggleButton1.setName("jToggleButton1"); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("ping /?");
        jTextField1.setName("jTextField1"); // NOI18N

        jButton1.setText("jButton1");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(72, 72, 72)
                                                .addComponent(jToggleButton1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(142, 142, 142)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton1)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton1)
                                .addGap(58, 58, 58)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            UserProg();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 50 /* keep small for testing */);
            final OutputStreamWriter osw = new OutputStreamWriter(System.out);
            String line;
            while ((line = br.readLine()) != null) {
                osw.write(line);
                osw.write("\n");
            }
            br.close();
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }

    static Process proc = null;
    static InputStream In = null;
    static OutputStream Out = null;
    static InputStream Err = null;


    public static void UserProg() throws IOException {
        proc = Runtime.getRuntime().exec(jTextField1.getText());
        In = proc.getInputStream();
        Out = proc.getOutputStream();
        Err = proc.getErrorStream();

        final BufferedReader brSin = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bwOut = new BufferedWriter(new OutputStreamWriter(Out));

        new Thread(new Runnable() {
            public void run() {
                try {
                    for (; ; ) {
                        String line = null;
                        while ((line = brSin.readLine()) != null) {
                            bwOut.write(line + "\n");
                            bwOut.flush();
                        }
                    }
                } catch (IOException e) {
                    ShowMessage(e);
                }
                ;
            }
        }).start();

        final BufferedReader brIn = new BufferedReader(new InputStreamReader(In));
        final BufferedWriter brSout = new BufferedWriter(new OutputStreamWriter(System.out));
        //final BufferedWriter brSout = new BufferedWriter(new PrintWriter(System.out,true));
        //final PrintStream brSout = new PrintStream(System.out,true);
        //final PrintWriter brSout = new PrintWriter(System.out,true);

        new Thread(new Runnable() {
            public void run() {
                try {
                    for (; ; ) {
                        String line = null;
                        while ((line = brIn.readLine()) != null) {
                            brSout.write(line + "\n");
                            brSout.flush();
                            //brSout.println(line);
                        }
                    }
                } catch (IOException e) {
                    ShowMessage(e);
                }
                ;
            }
        }).start();

        final BufferedReader brErr = new BufferedReader(new InputStreamReader(Err));
        final BufferedWriter brSerr = new BufferedWriter(new OutputStreamWriter(System.err));
        new Thread(new Runnable() {
            public void run() {
                try {
                    for (; ; ) {
                        String line = null;
                        while ((line = brErr.readLine()) != null) {
                            brSerr.write(line + "\n");
                            brSerr.flush();
                        }
                    }
                } catch (IOException e) {
                    ShowMessage(e);
                }
                ;
            }
        }).start();
    }

    private static void ShowMessage(Exception mess) {
        String ms = null;
        if (mess.getLocalizedMessage() == mess.getMessage()) ms = "ErrorMessage: " + mess.getMessage();
        else ms = "Message: " + mess.getMessage() + "\nLocalizedMessage :" + mess.getLocalizedMessage();
        if (!mess.toString().contains(mess.getMessage()) && !mess.toString().contains(mess.getLocalizedMessage()))
            ms = "ExceptionObject :" + mess.toString() + "\n" + ms;
        else ms = mess.toString();
        JOptionPane.showConfirmDialog(null, ms, "Error", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
        ms = null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IoApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private static javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration                   

}
