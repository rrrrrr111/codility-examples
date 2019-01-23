/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.operator;

/**
 * 1. Унарки выполняются как над значениями так и над переменными и полями.
 * 2.
 * 3.  b = 00000000 00000000 00000000 00001111
 * с = 11111111 11111111 11111111 11110000
 *
 * 4. префиксная и постфиксная запись инкремента и дектремента имеет отличия
 * 5. Следует отметить, что в Java, в отличие от языка C, операции декремента и
 * инкремента могут применяться и к вещественным переменным (типа float и double).
 *
 * 6. Дектремент и инкремент применяется ко всем числовым типам
 *
 * 7. ~ оператор побитового инвертирования
 *
 * @author дтоь 13.03.2011
 */
public class Unary {

    public static void main(String[] args) {

        int a = -1, b = 15, c, d = 2;
        short e = 2;
        long f = 2;
        char g = 2;
        byte h = 2;
        float i = 2;
        double j = 2;

        System.out.println(~-1);
        System.out.println(-(-1));
        System.out.println(+(-1));

        System.out.println("~-2 =>" + ~-2 + "  ~-1 =>" + ~-1 + "  ~0 =>" + ~0 + "  ~1 =>" + ~1 + "  ~2 =>" + ~2);
        System.out.println(-a);
        System.out.println(+a);

        System.out.println(b + " " + (c = ~b));

        System.out.println(++d);
        System.out.println(e++);

        System.out.println(--f);
        System.out.println(g--);
        System.out.println(h--);
        System.out.println(--i);
        System.out.println(j--);


    }
}
