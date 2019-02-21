/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.operator;

/**
 * 1. После запятой можно перейти на следующую строку..
 * 2. Результаты присваивания и сравнения выполняются справа налево...
 *
 * @author дтоь 12.01.2008
 */
public class Compare {

    public static void main(String[] args) {
        boolean isEqual, isNonEqual, isGreater,
                isGreaterOrEqual, isLess, isLessOrEqual;


        boolean r1 = 5 == 5;        // true
        boolean r2 = 5 != 5;        // false
        boolean r3 = 5 <= 5;        // true


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
