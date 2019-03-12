/*
 * Created on 28.11.2009, 13:53:12
 */
package ru.roman.certification.jcl.crypto;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author העמ
 */
class SecurityManager {

    public static void main(String[] args) {

        System.setSecurityManager(new java.lang.SecurityManager());

        String file = "authorized.txt";
        String fileBody = "body";
        FileWriter fw = null;

        try {

            fw = new FileWriter(file);

            fw.write(fileBody);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {/* silent */}
            }
        }
    }
}
