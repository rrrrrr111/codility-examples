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
public class Combination {

    public static void main(String[] args) {

        int x = 1, b = 2;

        x += b;  // x = x + b
        x -= b;  // x = x - b
        x *= b;   // x = x * b
        x /= b;   // x = x / b
        x %= b;   // x = x % b
        x &= b;   // x = x & b
        x |= b;   // x = x | b
        x ^= b;   // x = x ^ b
        x <<= b;  // x = x << b
        x >>= b;  // x = x >> b
        x >>>= b; // x = x >>> b
    }
}
