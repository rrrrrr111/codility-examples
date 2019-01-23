/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.operator;

/**
 * 1. Работает только в типами размеров меньше и равно 32 , тоесть видимо
 * производит преобразование всех типов в int,
 *
 * 2. При принудительном преобразовании работает и с остальными , кроме boolean
 * устественно. поскольку не преобразовывается boolean
 *
 * 3. Если после case ни стоит выражение с действиями, то такие case-ы
 * объединяются в группы и работают вместе последовательно до первого break;
 *
 * 4. switch поддерживает блоки кода .. .
 *
 * 5. default: - выполняется всегда
 *
 * 6. Выражения после сработавшего блока - тоже выполняются ,
 * после не сработавшего блока не выполняются .. ., это значит ,
 * что использвания блоков кода в операторе абсолютно не
 * обязательно  .. . тем не менее переменная объявленная
 * вне switch не доступна
 *
 * @author дтоь 13.03.2011
 */
public class Switch {

    // числовые типы
    // целые типы           размер      мин                 макс
    static short a1;        //16       -32768               32767       знаковый
    static int a2;          //32       -2147483648          2147483648  знаковый
    static long a3;         //64       -922372036854775808  922372036854775807  знаковый
    static char a4;         //16        0                   65536       беззнаковый
    static byte a5;         //8         -128                127         знаковый
    // числовые типы
    // вещественные типы                                        точность
    static float a6;        //32        3,4e-38 < |x| < 3,4e38      7-8 цифр
    static double a7;       //64        1,7e-308 < |x| < 1,7e308    17 цифр
    //булевский тип
    static boolean a8;      //8

    public static void main(String[] args) {
        switch (a1) {
            case 34:
                System.out.println(a1);
        }

        switch (a2) {
            case 34:
                System.out.println(a2);
        }

        switch ((int) a3) {      // long не катит , только с преобразованием
            case 34:
                System.out.println(a3);
        }

        switch (a4) {
            case 34:
                System.out.println(a4);
        }

        switch (a5) {
            case 34:
                System.out.println(a5);
        }

        switch ((int) a6) {        // float не катит , только с преобразованием
            case 0:
            case 34:
                System.out.println("6 - " + a6);
                System.out.println("1");
        }
        System.out.println("2");

        switch ((int) a7) {       // double не катит , только с преобразованием
            case 34: {
                int b = 0;
                System.out.println(a7);
            }
            System.out.println("3");
            default:
                System.out.println("4");
                int t = 0;
        }
        //System.out.println(t);  переменная вне switch не доступна

        //switch (a8) {        // boolean вообще ни как ни катит
        //    case 34:
        //        System.out.println(a1);
        //}


    }
}
