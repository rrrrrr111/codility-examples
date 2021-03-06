/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.operator;

/**
 * 1. · вычисление остатка от деления целых чисел "%" (возвращает остаток от
 * деления первого числа на второе, причем результат будет иметь тот же знак,
 * что и делимое)
 * - В Java эта операция может использоваться и для вещественных переменных
 * (типа float или double). При этом возвращаетс остаток с соответствующей
 * дробью
 * <p>
 * 2. при делении маленького числа на большое , все маленькое
 * число остается в остатке
 *
 * @author churganov_r 19.03.2011
 */
class BinaryArithmetic {

    public static void main(String[] args) {

        byte b1 = -1, b2 = 15, b3, b4 = 2, b5 = 2, b6 = 2, b7 = 2;
        int i1 = -1, i2 = 15, i3, i4 = 2, i5 = 2, i6 = 2, i7 = 2;
        float f1 = -1, f2 = 15, f3, f4 = 2, f5 = 2, f6 = 2, f7 = 2;

        float r1 = 7 + 3f;              // 10.0 - если хотябы один операнд float второй тоже приводится к float
        // int r11 = f1 + f2;           // illegal
        float r12 = 3.4e38f * 2;        // Infinity - не ругатся даже при overflow
        double r13 = 3.4e38f * 2;       // Infinity - по идее double вмещает результат, однако все равно происходит overflow в
        // результате т к идет вычисление с результатом типа float
        double r14 = 3.4e38f * 2d;      // 6.7999999042887285E38

        byte r2 = 126 + 1;               // на литералах компилятор не ругается, если видит что результат не вылазит
        // однако для всех вычислений byte short int char результат int
        //byte r3 = b1 - b2;            // illegal, required int found byte
        //byte r4 =  777 + 7;           // illegal, required int found byte
        byte r41 = ((byte) 777777 + (byte) 777777);
        byte r42 = (byte) (777777 + 777777);

        int r5 = 711111111 * 311111111;  // overflow норм
        int r6 = 7 / 3;                  // 2 при делении int остаток отбрасывается, т к результат int
        double r7 = 7d / 3;              // 2.3333333333333335 при делении double остаток не отбрасывается
        byte r30 = 3 % -7;               // 3  знак делителя не влияет на результат
        byte r31 = -7 % -3;              // -1
        byte r32 = -7 % 3;               // -1
        byte r33 = 7 % -3;               // 1
        byte r34 = 7 % 3;                // 1, пока результат не вылазит компилятор не ругается

        //int r35 = 7.5f % -3f;           // illegal, float нельзя в int, даже если влазит
        float r35 = 7.5f % -3f;           // 1.5 modulo работает также и с вещественными, знак отбразывается аналогично
        //float r36 = 7.5f % 3d;          // illegal, double нельзя во float, даже если влазит
        double r36 = 7.5f % 3d;           // 1.5
        double r37 = 7.5d / -3d;          // -2.5
        float r38 = -7.5f / 388f;         // -0.019329896

        //long r51 = 7f / 1L;             // illegal, результат float, т к float вмещает бОльшие значения, хотя и меньше по размеру
        //int r51 = 7 / 1L;               // illegal, результат long, даже если вмещается
        char r51 = 7 / 1;                 // а для int норм
        short r52 = 7 / 1;                //
        byte r53 = 7 / 1;                 //
        //int r54 = 7f / 1;               // illegal, float нельзя в int

        String r60 = 11 + 1 + "12";       // 1212 все что прибавляется к String становится String, однако операции идут слева направо
        String r61 = 0 + '0' + "-0";      // 48-0 у ноля код 48
        String r62 = 1 + 1L + "\377";     // 2ÿ
        String r63 = 1F + 0b1 + "™";      // 2.0™
        String r64 = 1 + 0x0 + "\u2665";                   // 1♥
        String r641 = "" + "\u0065\u0301";                 // é  декомпозированная графема из двух символов
        String r65 = 00 + 0x0 + "\u1112\u1161\u11AB";      // 0한  декомпозированная графема из трех символов
        String r66 = 0000000 + "\uD55C";                   // 0한  прекомпозированный символ, лидирующие нули octal числа отброшены


        System.out.println(">>> " + r641);

    }
}
