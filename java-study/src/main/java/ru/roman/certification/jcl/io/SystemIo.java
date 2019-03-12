/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.jcl.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Роман 20.01.2008 JDK 1.5
 */
class SystemIo {

    void Check(String command) throws IOException {
        Process proc = Runtime.getRuntime().exec(command);
        InputStream In = proc.getInputStream();
        BufferedReader brIn = new BufferedReader(new InputStreamReader(In));
        BufferedWriter brSout = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;
        while ((line = brIn.readLine()) != null) {
            brSout.write(line + "\n");
            brSout.flush();
        }
    }

    public static void main(String args[]) {
        try {
            new SystemIo().Check(args[0]);
//             new System_IO_CheckUsingCSP().Check("ping /?");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
