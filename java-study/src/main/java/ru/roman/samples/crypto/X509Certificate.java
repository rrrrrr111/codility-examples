/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.samples.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

//CertificateX509Key;

/**
 * @author Roman
 */
class X509Certificate {

    void readCer() {
        try {
            File xml_file = new File("C:\\1_work\\036TRANSACT\\ThinkClientKMB-BANK\\CRYPTO\\PUBLIC\\00000000\\263DDF3F0000000027A7.cer");
            FileInputStream in = new FileInputStream(xml_file);
            CertificateFactory factory2 = CertificateFactory.getInstance("X.509");
            Certificate gCert = factory2.generateCertificate(in);

            //System.out.println( gCert.getPublicKey()+"\n===============\n"+
            //                  gCert.getType()+"\n==================\n"+
            //                gCert.toString()+"\n==================\n"+
            //              gCert.getEncoded()+"\n==================\n"+
            //            gCert.getEncoded()+"\n==================\n");

            //X509CertImpl c = new X509CertImpl(new X509CertInfo(gCert.getEncoded()));
            //X509CertInfo c = new X509CertInfo(new DerValue("ASDDSA"));
            System.out.println(gCert.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }

    }

    void readCertX509() {
        try {
            File xml_file = new File("C:\\1_work\\036TRANSACT\\ThinkClientKMB-BANK\\CRYPTO\\PUBLIC\\00000000\\263DDF3F0000000027A7.cer");
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            FileInputStream in = new FileInputStream(xml_file);
            Certificate gCert = cf.generateCertificate(in);
            System.out.println(gCert.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new X509Certificate().readCertX509();
    }
}
