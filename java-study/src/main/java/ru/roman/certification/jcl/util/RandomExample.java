/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.jcl.util;

import java.util.Arrays;
import java.util.Random;

/**
 * @author churganov_r
 */
class RandomExample {

    private static final Random random = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // random.setSeed(1);
        for (Integer i : Arrays.asList(new Integer[10])) {
            System.out.println("Gaussian:" + random.nextGaussian());
            System.out.println("Int:" + random.nextInt());
            System.out.println("Int 10:" + random.nextInt(10));
        }
    }
}
