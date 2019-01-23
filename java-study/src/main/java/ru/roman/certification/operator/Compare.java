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

        int x1 = 5, x2 = 5, x3 = 3, x4 = 7;
        isEqual = x1
                == x2; // isEqual = true
        isNonEqual = x1 != x2; // isNonEqual = false
        isGreater = x1 > x3; // isGreater = true
// isGreaterOrEqual = true
        isGreaterOrEqual = x2 >= x3;
        isLess = x3 < x1; // isLess = true
        isLessOrEqual = x1 <= x3; // isLessOrEqual = false
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
