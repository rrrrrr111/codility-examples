package ru.roman.certification.primitives;

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
            Boolean.parseBoolean("sdfsd.0"); // true только если передать true ignoreCase, не кидает ошибок формата
        }

        {           // получение систем пропертей
            //Short.getShort("0");
            //Byte.getByte("0");
            //Character.getCharacter("");
            Integer.getInteger("obance");            // null если нету или если кривое
            Long.getLong("obance", 0L);    // оверлод с дефолтным значением
            //Float.getFloat("0");
            //Double.getDouble("0");
            Boolean.getBoolean("obance"); // true если есть такое систем проперти и оно true, иначе false не очевидно
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

        {                 // примитив в строку
            //Short.toBinaryString((short) 0);  // illegal
            //Byte.toBinaryString((byte) 0);  // illegal
            //Character.toBinaryString('c');  // illegal
            Integer.toBinaryString(0);
            Long.toBinaryString(0L);
            //Float.toBinaryString(0f);  // illegal
            //Double.toBinaryString(0d);  // illegal
            //Boolean.toBinaryString(true);  // illegal
        }
    }
}
