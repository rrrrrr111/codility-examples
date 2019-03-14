/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.operator;

import static org.apache.commons.lang3.StringUtils.leftPad;

/**
 * @author churganov_r 22.03.2011
 */
class Shift {

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(2147483647));
        System.out.println(Integer.toBinaryString(2147483646));
        System.out.println(Integer.toBinaryString(2147483645));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-2147483646));
        System.out.println(Integer.toBinaryString(-2147483647));
        System.out.println(Integer.toBinaryString(-2147483648));
        System.out.println("=================================================");

        System.out.println(-1 >> 1);  // сдвиг с учетом знакового бита ... 1111111111111111111111111111111 -> 1111111111111111111111111111111
        System.out.println(-1 >>> 1);  // сдвиг cо сдвигом знакового бита ... 1111111111111111111111111111111 -> 0111111111111111111111111111111
        System.out.println(-1 << 1);  // сдвиг с учетом знакового бита ... 1111111111111111111111111111111 -> 1111111111111111111111111111110
        System.out.println(-1 >> 2);  // сдвиг с учетом знакового бита ... 1111111111111111111111111111111 -> 1111111111111111111111111111111
        System.out.println(-1 >>> 2);  // сдвиг без учета знакового бита ... 1111111111111111111111111111111 -> 0011111111111111111111111111111
        System.out.println(-1 << 2);  // сдвиг с учетом знакового бита ... 1111111111111111111111111111111 -> 1111111111111111111111111111100
        System.out.println("=================================================");

        System.out.println(1 >> 1);   // 001 -> 000
        System.out.println(1 >>> 1);  // 001 -> 000
        System.out.println(1 << 1);   // 001 -> 010 = 2
        System.out.println(1 >> 2);   // 001 -> 000
        System.out.println(1 >>> 2);  // 001 -> 000
        System.out.println(1 << 2);   // 001 -> 100 = 4
        System.out.println("=================================================");

        System.out.println(0 >> 1);   // 000 -> 000
        System.out.println(0 >>> 1);  // 000 -> 000
        System.out.println(0 << 1);   // 000 -> 000
        System.out.println(0 >> 2);   // 000 -> 000
        System.out.println(0 >>> 2);  // 000 -> 000
        System.out.println(0 << 2);   // 000 -> 000
        System.out.println("=================================================");


    }
}

class CountBits {

    static int count(short s) {
        int bits = 0;
        while (s != 0) {
            bits += s & 1;               // BNP & infinite loop,
            s >>>= 1;
            System.out.println(Integer.toBinaryString(s));
        }
        return bits;
    }

    public static void main(String[] args) {
        //int count = count((short) -1);
        //System.out.println(count);
        //System.out.println(Integer.toBinaryString(-1 >>> 31));

        int i = 0xfffda7f6;
        System.out.println((i * 32 == i << 5)
                + " \n>> " + leftPad(Integer.toBinaryString(i), 50)
                + " \n>> " + leftPad(Integer.toBinaryString(i * 32), 50)
                + " \n>> " + leftPad(Integer.toBinaryString(i << 5), 50));
    }
}