/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.operator;

/**
 * 1. Оператора x ~= b не существует
 * 2.
 *
 * @author churganov_r 19.03.2011
 */
class Combination {

    public static void main(String[] args) {

        int x = 1, y = 2;

        x += y;  // x = (int)(x + y)
        x -= y;  // x = (int)(x - y)
        x *= y;   // x = (int)(x * y)
        x /= y;   // x = (int)(x / y)
        x %= y;   // x = (int)(x % y)
        x &= y;   // x = (int)(x & y)
        x |= y;   // x = (int)(x | y)
        x ^= y;   // x = (int)(x ^ y)
        x <<= y;  // x = (int)(x << y)
        x >>= y;  // x = (int)(x >> y)
        x >>>= y; // x = (int)(x >>> y)

        boolean r09 = true;
        //boolean r10 != r09;     // illegal, not equals is not assignment
        boolean r11 =! r09;     // false кривое форматирование

        byte b1 = 127;
        b1 += 0x7fffffff;              // 126 - вычисления по прежнему выполняются в int, и тут явно overflow
                                       // однако assignment делают неявное приведение типа, явное приведение тут некуда вставиить
        b1 += 0x7fffffffffffffffL;     // 126
        b1 += 3.4E307D;                // -1

        float f1 = 3.4E38f;
        f1 *= 3.4E307d;                // Infinity

        System.out.println(f1);
    }
}
