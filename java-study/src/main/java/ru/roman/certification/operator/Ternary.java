/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.operator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
class Ternary {


    public static void main(String[] args) {


        float a1 = true ?  1L : 1f;  // проверки резулитирующего типа как при приведении, если widening то компилит
        //long a2 = true ?  1L : 1f;  // illegal, narrowing только если явно указать приведение
        long a3 = true ?  Integer.valueOf(1) : 1L;  // врапперы норм, если widening
        float a4 = true ?  Long.valueOf(1) : 1f;
        Float a41 = true ?  Long.valueOf(1) : 1f;
        //Double a42 = true ?  Long.valueOf(1) : 1f;  // illegal, результирующий тип float не идет в double
        byte a5 = true ?  -128 : 127;
        //byte a6 = true ?  -129 : 127;  // illegal, аналогично обчной инициализации
        List<String> a7 = true ?  new ArrayList<>() : new LinkedList<>();
        // List<String> a = true ?  new HashSet<String>() : new LinkedList<>(); // illegal
        Collection<String> a = true ?  new HashSet<String>() : new LinkedList<>(); // LUB и type inference для 3 операнда

        int t = 1;
        //var v = false ? t = 0: t = 1;  // illegal

        final var i = 50; var c = 'f';
        var r1 = true ? i : c;                 // char 2 т к код двойки 50, т к переменная final компилятор работает с ней
                                               // как с compile-time константой, если убрать final у i, r будет 50
        var r2 = true ? 12 : 'a';              // char т к для byte, short и char если второй операнд compile-time int
                                               // он сужжается до второго операнда
        var r3 = true ? 12 : Character.valueOf('a');  // Character
        char r31 = true ? 12 : Character.valueOf('a');  // char
        //var r4 = false ? 12 : Byte.valueOf("128");  // Byte, но NumberFormatException: Value out of range
        final Integer i1 = 1;
        //char r = true ? i1 : 'd';              // illegal, compile-time константа Integer не сужжается
        //byte r = true ? Integer.valueOf(1) : 1;  // illegal
        //byte r = true ? Integer.valueOf(1) : (byte) 1;  // illegal
        //Integer r = true ? Integer.valueOf(1) : Long.valueOf(1);  // illegal
        Long r5 = true ? Integer.valueOf(1) : Long.valueOf(1);    // враппер расширяется до второго враппера
        //Float r = true ? Integer.valueOf(1) : Long.valueOf(1);  // illegal, результирующий тип не расширяется
        float r51 = true ? Integer.valueOf(1) : Long.valueOf(1);  // но расширяются до приметива
        //int r = true ? Integer.valueOf(1) : Long.valueOf(1);  // illegal
        Float r6 = true ? Integer.valueOf(1) : Float.valueOf(1);
        //Short r7 = true ? Short.valueOf((short) 1) : Integer.valueOf(1);  // illegal
        //short r7 = true ? Short.valueOf((short) 1) : Integer.valueOf(1);  // illegal, тут не приметивы
        List l = null;
        Object r7 = true ? Long.valueOf(1) : l;
        Object r8 = true ? null : l;
        Object r9 = true ? null : null;
        Long r10 =  true ? Long.valueOf(1) : null;  // Long 1
        long r11 =  true ? Long.valueOf(1) : null;  // long 1
//      long r12 =  false ? Long.valueOf(1) : null;  // NullPointerException
        Long r13 =  false ? Long.valueOf(1) : null;  // null

        //Long p =  true ? 1 : null;  // Illegal, результирующий тип Integer
        Long p1 =  true ? 1L : null;  // 1
        var p11 =  true ? 1L : null;  // Long 1
        var p12 =  true ? 1L : Long.valueOf(1);  // long 1
        long p2 =  true ? 1L : null;  // 1
        var p3 =  false ? 1L : null;  // NullPointerException
        Long p4 =  false ? 1L : null;  // null, unboxing второго операнда был бы при присвоении в приметив
        Object p5 =  false ? 1L : null;  // null
        //Object p6 = false ? 1L : false ? 1L : null; // NullPointerException вложенное выражение дает null,
                                                    // и результирующий тип у него Long, все норм,
                                                    // но дальше результирующий тип long и компилятор вставляет
                                                    // unboxing
        final Integer i2 = null;
        Object p =  false ? 1L : i2;  // NullPointerException
        Object p8 = one() ? two() : three() ? four() : five();  // 1 3 5
        //System.out.println(p);


    }

    static boolean one() {
        System.out.print("1 ");
        return false;
    }

    static int two() {
        System.out.print("2 ");
        return 2;
    }

    static boolean three() {
        System.out.print("3 ");
        return false;
    }

    static int four() {
        System.out.print("4 ");
        return 4;
    }

    static int five() {
        System.out.print("5 ");
        return 5;
    }
}
