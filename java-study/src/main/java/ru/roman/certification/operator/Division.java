/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.operator;

/**
 * @author churganov_r
 */
final class Division {

    static double some1 = 0;
    static double some2 = 1;
    static int some3 = 0;
    static int some4 = 0;

    public static void main(String args[]) {
        try {
            // Деление double 0 на double 0 = NaN
            // Деление double 1 на double 0 = Enfinity

            System.out.println(some1);
            System.out.println(some2);
            System.out.println(some1 / some2);

            // Деление int 0 на int 0 = ArithmeticException
            // Деление int 1 на int 0 = ArithmeticException

            System.out.println(some3);
            System.out.println(some4);
            System.out.println(some3 / some4);

            // Если исключение перехвачено, компилятор не даст перехватить второе исключение более узкого типа, но даст более широкого

            //} catch ( Exception e) {
            //  System.out.println("Exception");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        }
    }
}
