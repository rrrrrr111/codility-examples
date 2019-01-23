/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.operator;

import java.io.Serializable;

import static ru.roman.certification.util.ReplUtil.evaluate;

/**
 * 1. В качестве первого операнда может быть исполь-зовано любое выражение,
 * результатом которого является значение типа boolean
 *
 * 2. Если первый операнд = true , то выполняется второй операнд, если
 * false то третий .. .
 *
 * 3. второй и третий операнд должны возвращать значения одинакового типа
 * ( правило строгое и проверяется компилятором),
 *
 * 3.1 оператор всегда преобразует выходное значение к общему для обоих выражений типу
 * например к int если один возвращает short другой int, если преобразование не возможно
 * будет ошибка компиляции
 *
 * 4. В третьем опреанде если испольовать результат присваивания
 * нужно брать его в скобки
 *
 * @author churganov_r 17.03.2011
 */
public class Ternary {

    static int int1, int2;
    static boolean bool1, bool2;
    static float float1, float2;
    static short short1, short2;
    static double double1, double2;
    static long long1, long2;

    public static void main(String[] args) {

        // 1
        evaluate("int int1 = 0;int int2 = 0;(int1 >= 0 ? int2 = 1 : (int2 = 2));", int1 >= 0 ? int2 = 1 : (int2 = 2));
        // 2 принудительной проверки типов нет в этом интерпретаторе скриптов, а вообще есть
        evaluate("int int1 = 0;int int2 = 0;boolean aBool = (int1 > 0 ? int2 = 1 : int2 == 2);aBool", (int1 > 0 ? int2 = 1 : int2 == 2));
        // есть приверки типов компилятором при присвоении, рекомендуется использовать Serializable если разные типы
        //boolean aBool1 = (int1 >= 0 ? int2 : bool2);  // не катит
        boolean aBool2 = (int1 >= 0 ? bool1 : bool2);  // катит
        int ares1 = (int1 >= 0 ? new Integer((int) 3) + 1 : int1);  // катит
        Serializable aSer1 = (int1 >= 0 ? int1 + 1 : bool1);  // катит
        int ares2 = (int1 >= 0 ? int1 + 1 : short1);  // катит
        double ares3 = (int1 >= 0 ? double2 + 1 : short1);  // катит
        double ares4 = (int1 >= 0 ? double1 + 1 : float2);  // катит
        //long ares5 = (int1 >= 0 ? long1 + 1 : float2);  // не катит
        long ares6 = (false ? Short.valueOf("3") : new Integer((int) 3));  // катит


    }
}
