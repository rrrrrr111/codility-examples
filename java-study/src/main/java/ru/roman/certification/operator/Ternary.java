/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.operator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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


    public static void main(String[] args) {


        float a1 = true ?  1L : 1f;  // проверки резулитирующего типа как при приведении, если widening то компилит
        //long a2 = true ?  1L : 1f;  // illegal, narrowing только если явно указать приведение
        long a3 = true ?  Integer.valueOf(1) : 1L;  // врапперы норм, если если widening
        float a4 = true ?  Long.valueOf(1) : 1f;
        byte a5 = true ?  -128 : 127;
        //byte a6 = true ?  -129 : 127;  // illegal, аналогично обчной инициализации
        List<String> a7 = true ?  new ArrayList<>() : new LinkedList<>();
        // List<String> a = true ?  new HashSet<String>() : new LinkedList<>(); // illegal

        int t = 1;
        //var v = false ? t = 0: t = 1;  // illegal
    }
}
