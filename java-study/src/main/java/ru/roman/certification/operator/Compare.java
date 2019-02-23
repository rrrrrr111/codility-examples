/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.operator;

import java.math.BigDecimal;

/**
 * 1. После запятой можно перейти на следующую строку..
 * 2. Результаты присваивания и сравнения выполняются справа налево...
 *
 * @author дтоь 12.01.2008
 */
public class Compare {

    public static void main(String[] args) {

        boolean r1 = 5 == 5;        // true
        boolean r2 = 5 != 5;        // false
        boolean r3 = 5 <= 5;        // true

        boolean r4 = ((short)5) == 5.;        // true
        boolean r5 = 48 == '0';               // true
        boolean r = 1L == (byte)1;            // true

        Integer i1 = null, i2 = null;
        Runnable run = null;
        BigDecimal dec = null;
        Long l1 = null, l2 = null;
        boolean r18 = (Number)l1 == i2;           // после cast типы совместимы, но без cast illegal т к Integer final
        //boolean r19 = "dd" == run;              // illegal String is final
        //boolean r19 = l1 == run;                // illegal Long is final
        boolean r19 = (Number)l1 == run;
        boolean r = dec == run;                   // ok BigDecimal не final

        System.out.println(r);


        System.out.print((one() < two()) + "\n");
        System.out.print((one() <= two()) + "\n");
        System.out.print((one() >= two()) + "\n");
        System.out.print((one() + two()) + "\n");
        System.out.print((one() - two()) + "\n");
        System.out.print((one() * two()) + "\n");
        System.out.print((one() / two()) + "\n");
        System.out.print((one() % two()) + "\n");
        System.out.print((one() >> two()) + "\n");
        System.out.print((one() >>> two()) + "\n");
        System.out.print((one() << two()) + "\n");
    }

    static int one() {
        System.out.print(1);
        return 1;
    }

    static int two() {
        System.out.print(2);
        return 2;
    }
}
