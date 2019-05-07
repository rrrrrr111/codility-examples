package ru.roman.jcl.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * see https://docs.oracle.com/javase/9/docs/specs/security/standard-names.html#additional-jsse-standard-names
 */
class MessageDigestExample {

    private static String hash(String input, String algorithm) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] messageDigest = md.digest(input.getBytes());

        BigInteger no = new BigInteger(1, messageDigest);

        StringBuilder str = new StringBuilder(no.toString(16));
        while (str.length() < 32) {
            str.insert(0, "0");
        }
        return str.toString();
    }

    public static void main(String args[]) throws NoSuchAlgorithmException {
        System.out.println("MD2 is: " + hash("Hello world", "MD2"));
        System.out.println("MD5 is: " + hash("Hello world", "MD5"));
        System.out.println("SHA-256 is: " + hash("Hello world", "SHA-256"));
        System.out.println("SHA3-256 is: " + hash("Hello world", "SHA3-256"));
    }
}
