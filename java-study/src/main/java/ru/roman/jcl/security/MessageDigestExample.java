package ru.roman.jcl.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 *
 */
class MessageDigestExample {

    private static String getMd5(String input) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());

        BigInteger no = new BigInteger(1, messageDigest);

        StringBuilder str = new StringBuilder(no.toString(16));
        while (str.length() < 32) {
            str.insert(0, "0");
        }
        return str.toString();
    }

    public static void main(String args[]) throws NoSuchAlgorithmException {
        System.out.println("MD5 is: " + getMd5("Hello world"));
    }
}
