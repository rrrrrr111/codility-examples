/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.primitives;

/**
 * 1. & на 0xff возвращает результат с количеством битов в меньшем из операндов
 * , и следовательно приводит к убиранию знака если 0xff короче второго опреранда со знаком
 * при этом данная операция не изменяет исходного числа. Это называется приведение по маске.
 * При этом вернуть число в исходное можно обычным кастом к byte
 *
 *
 * 2. Результат на выходе данной операции имеет тип Integer
 *
 * 3. оператор == не выполняет приведение типов
 *
 * 4. Если умножать на малую маску, например 0xf то все числа будут в диапазное 0 - 15,
 * если на большую, например 0xfff - то диапазон преобразованных положительныз значений начнется с большего числа
 *
 * 5. Число 11111111111111111111111111111111 соответствует типу int зо значением -1
 * 10000000 соответствует типу byte зо значением -128
 * 10000001 соответствует типу byte зо значением -127
 * 11111111 соответствует типу byte зо значением -1
 * метод Integer.toBinaryString(b) - делает приведение к int перед выводом в консоль и не отображает лидирующие нули,
 * поэтому в дальнейшем чтобы читать его вывод отбрасываем лишние лидирующие единицы
 *
 * @author churganov_r 15.03.2011
 */
public class ByteExample {

    public static void main(String[] args) {

        int r = -1 & 0xff;  // ....00011111111 - приведение по маске, для любого числа отбрасывает старшие биты


        int mask = 0xff;
        byte b = java.lang.Byte.MIN_VALUE;
        System.out.printf("0xff => %s = %s = %s = %s %n", mask,
                Integer.toBinaryString(mask), Integer.toBinaryString(-1), (byte)0b11111111111111111111111111111111);

        for (; ; ) {
            System.out.printf("byte:%s  maskedIntToByte:%s  maskedInt:%s  binByteToInt:%s  binMaskedByteToInt:%s  %n",
                    b, (byte) (b & mask), (b & mask), Integer.toBinaryString(b), Integer.toBinaryString((b & mask)));
            if (b == 0x90) {
                System.out.print("Joy! ");
            }
            if (b == java.lang.Byte.MAX_VALUE) {
                break;
            }
            b++;
        }
    }
}
