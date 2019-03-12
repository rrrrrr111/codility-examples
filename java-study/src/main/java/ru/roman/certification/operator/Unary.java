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
 * <p>
 * 4. префиксная и постфиксная запись инкремента и дектремента имеет отличия
 * 5. Следует отметить, что в Java, в отличие от языка C, операции декремента и
 * инкремента могут применяться и к вещественным переменным (типа float и double).
 * <p>
 * 6. Дектремент и инкремент применяется ко всем числовым типам
 * <p>
 * 7. ~ оператор побитового инвертирования
 *
 * @author дтоь 13.03.2011
 */
class Unary {

    public static void main(String[] args) {

        byte r00 = ~1;         // -2 - 00000001 -> 11111110
        int r01 = ~1;          // -2 - 00000000000000000000000000000001 -> 11111111111111111111111111111110
        int r02 = +(-1);       // -1
        int r03 = -(-1);       // 1
        float r04 = -(-1f);    // 1.0
        //float r05 = ~1f;       // illegal
        int r06 = -0x80000000;   // -2147483648
        int r07 = -(-0x80000000);   // -2147483648 - min int - уникальный кейс, все integral аналогично

        //int r08 = --1;   // illegal
        int min = 0x80000000;
        ++min;                   // -2147483647
        --min;                   // 2147483647 overflow
        float minF = -3.4e38f;
        --minF;                  // -3.4E38 - по идее overflow, однако из-за дискретности округляется к изначальному

        boolean r09 = !true;     // false

        System.out.println(">>> " + minF);
    }
}
