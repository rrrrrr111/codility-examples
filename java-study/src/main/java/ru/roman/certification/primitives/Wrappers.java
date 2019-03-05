package ru.roman.certification.primitives;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 *
 */
public class Wrappers {

    public static void main(String[] args) {

        {       // методы parse... возвр соотв примитив, кидают unchecked NumberFormatException
            Short.parseShort("0");
            Byte.parseByte("0");
            // Character.parse;            // нет, зачем парсить символ
            Integer.parseInt("0");
            Long.parseLong("0");        // у целых есть оверлоды с передачей radix
            Float.parseFloat("0");
            Double.parseDouble("0");
            Boolean.parseBoolean("sdfsd.0"); // true только если передать true (ignoreCase), не кидает ошибок формата
        }

        {           // получение систем пропертей
            //Short.getShort("0");
            //Byte.getByte("0");
            //Character.getCharacter("");
            Integer.getInteger("obance");            // null если нету или если кривое
            Long.getLong("obance", 0L);    // оверлоды с дефолтным значением
            //Float.getFloat("0");
            //Double.getDouble("0");
            Boolean.getBoolean("obance"); // true если есть такое систем проперти и оно true, иначе false, не очевидно/криво
        }

        {            // методы с кэшом значений от -128 до 127
            Short.valueOf((short) 0);
            Byte.valueOf((byte) 0);
            Character.valueOf('c');     // нет оверлода для стринга
            Integer.valueOf(0);         // у остальных есть оверлоды для стринга, делегируются к соотв методам parse...
            Long.valueOf(0L);           //   однако эти вовзрв враппер а не примтив, есть также оверлоды для стринга с радиксом
            Float.valueOf(0f);          // Float и Double не кешируются,
            Double.valueOf(0d);
            Boolean.valueOf(true);
        }

        {       // конструкторы, аналогично соотв valueOf(..) но без кэша
            new Short((short) 0);
            new Byte((byte) 0);         // есть оверлоды под стринг, делегируются к parse...
            new Character('c');
            new Integer(0);
            new Long(0L);
            new Float(0f);
            new Double(0d);
            new Boolean(true);
        }

        {       // преобразования, аналогично соотв cast , все числа друг в дружку конвертятся
            Short.valueOf((short) 0).shortValue(); // свой примитив
            Short.valueOf((short) 0).byteValue();
            //Short.valueOf((short) 0).charValue();
            Short.valueOf((short) 0).intValue();
            Short.valueOf((short) 0).longValue();
            Short.valueOf((short) 0).floatValue();
            Short.valueOf((short) 0).doubleValue();
            //Short.valueOf((short) 0).booleanValue();

            Float.valueOf((short) 0).shortValue();
            Float.valueOf((short) 0).byteValue();
            //Short.valueOf((short) 0).charValue();
            Float.valueOf((short) 0).intValue();
            Float.valueOf((short) 0).longValue();
            Float.valueOf((short) 0).floatValue();
            Float.valueOf((short) 0).doubleValue();
            //Short.valueOf((short) 0).booleanValue();

            Character.valueOf('c').charValue();
            //Integer.valueOf((short) 0).charValue();
            Boolean.valueOf(true).booleanValue();
        }

        {                 // примитив в строку
            Short.toString((short) 0);
            Byte.toString((byte) 0);
            Character.toString('c');
            Integer.toString(0);
            Long.toString(0L);
            Float.toString(0f);
            Double.toString(0d);
            Boolean.toString(true);
        }

        {
            Integer.toBinaryString(0); // примитив в бинарную строку, у Long есть аналогичные методы
            Integer.toHexString(0);
            Long.toOctalString(0);
        }

        compare();
    }

    private static void compare() {

        boolean r1 = Integer.valueOf(1).equals(Byte.valueOf((byte) 1));      // false
        boolean r2 = Integer.valueOf(1).equals(Short.valueOf((short) 1));    // false
        boolean r3 = Integer.valueOf(1).equals(Integer.valueOf(1));          // true, врапперы матчатчатся только со своим типом

        //boolean r4 = Integer.valueOf(1) == Long.valueOf(1);                // illegal, assign сравнимает только одинаковые типы
        //boolean r4 = Integer.valueOf(1) != Long.valueOf(1);                // illegal
        boolean r5 = Integer.valueOf(127) == Integer.valueOf(127);           // true  кэширование
        boolean r6 = Integer.valueOf(128) == Integer.valueOf(128);           // false только для -128 <= x <= 127

        boolean r7 = Integer.valueOf(128) == 128;                            // true, второй операнд разбоксивается до приметива
        boolean r8 = 128 == Integer.valueOf(128);                            // true, если праппер будет равен null все равно будет
                                                                             // попытка разбоксинга и вылетит NullPointerException
        Number n = null;
        Number n1 = null;

        //boolean r80 = 128 == n;                             // illegal, Number не unboxing
        //boolean r80 = 128 == null;                             // illegal
        //boolean r80 = n >= 12;                                   // illegal, Number не unboxing
        boolean r81 = 128 == Float.valueOf(128.f);                // true

        boolean r9 = 128d > Integer.valueOf(127);           // true
        boolean r10 = 127L <= Byte.valueOf((byte) 127);           // true
        boolean r11 = Short.valueOf((short) 127) >= Float.valueOf(127f);           // true
        boolean r12 = 127L > Float.valueOf(126f);              // true

        boolean r13 = 127L > Character.valueOf('0');              // true
        boolean r14 = 'z' > 'Z';              // true


        Integer i1 = null, i2 = null;
        boolean r15 = i1 == i2;
        boolean r16 = i1 != i2;
        //boolean r17 = i1 >= i2;           // NullPointerException


        System.out.println(r81);
    }
}
