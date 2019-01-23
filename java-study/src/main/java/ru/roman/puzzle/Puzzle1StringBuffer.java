/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.puzzle;

import java.util.Random;

/**
 * 1.Всегда используй break в  switch
 *
 * 2. В данном примере символ задает размер StringBuffer
 *
 * @author churganov_r 15.03.2011
 */
public class Puzzle1StringBuffer {

    private static Random rnd = new Random();

    public static void main(String[] args) {
        StringBuffer word;

        switch (rnd.nextInt(2)) {
            case 1:
                word = new StringBuffer('P');
                break;
            case 2:
                word = new StringBuffer('G');
                break;
            default:
                word = new StringBuffer('M');
                break;
        }

        word.append('a');
        word.append('i');
        word.append('n');
        System.out.println(word);
    }
}
