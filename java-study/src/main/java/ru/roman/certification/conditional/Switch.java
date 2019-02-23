/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.conditional;

/**
 * 1. Работает только с byte, short, char, int / Character, Byte, Short, Integer, enum types и String (Java 7)
 * 2. Если после case ни стоит выражение с действиями, то такие case-ы (включая default) объединяются в группы (falls through labels) и работают вместе последовательно до первого break;
 * 3. switch поддерживает блоки кода опционально
 * 4. default: выполняется если ни один case не сработал
 *
 * @author дтоь 13.03.2011
 */
class Switch {


    public static void main(String[] args) {
        foo1((byte) 34);
    }

    private static void foo(byte a) {
        switch (a) {                                     // body of a switch statement is known as a switch block
            case 34:
                System.out.println("34 >>> " + a);
                int c;
                break;
            default:                                     // default может быть в любом месте
                System.out.println("default >>> " + a);  //
                                                         // если break нету выполняются следующий case, даже для default блока
            case 35: {                                   // это не block braces а обычный блок, перед ним можно вставить чтонить
                System.out.println("35 >>> " + a);
            }
            int b = 0;                                   // перед/после блока может быть что угодно
            break;
            //a++;                                       // illegal, unreachable
            case 36:
                c = 0;                                   // переменные из одного case доступны в другом, если они в том же блоке
            case 37:
                //c++;                                   // illegal компилятор не проверяет варианты ветвления
                                                         // инициализация обязательно должна быть минимум в текущем case
                System.out.println("36,37 >>> " + a);
                break;
            //case 38                                    // illegal двоеточие обязательно
            //case 37:                                   // illegal duplicate
            //case 128:                                  // illegal, too much for byte
            case 39:                                     // пустой блок вконце норм
        }                                                // тем не менее рекомендуется юзать break в последнем case
    }

    private static void foo1(byte a) {
        switch (a) {
            case 34:
                System.out.println("34 >>> " + a);      // если нет break, default тоже выполняется
            default:
                System.out.println("default >>> " + a);
        }
    }

    private static final String CONST = "v";
    private static final String CONST_INIT_IN_STATIC_BLOCK;
    private static final String CONST_INIT_BY_METHOD = getPart();
    static {
        CONST_INIT_IN_STATIC_BLOCK = "r";
    }

    private static void foo2(String str) {
        String part = "ss";
        switch (str.toLowerCase()) {                   // сравнение с case'ами идет через String.equals(...), можно поймать NullPointerException
            //case "jan" + getPart():                  // illegal, только константы времени компиляции
            //case "jan" + part:                       // illegal

            case "feb" + "dd":
            case CONST:
            //case CONST_INIT_IN_STATIC_BLOCK:         // illegal
            //case CONST_INIT_BY_METHOD:         // illegal

                break;
        }
    }

    private static short foo3(MyEnum myEnum) {
        switch (myEnum) {
            case VAL1:
                return 1;
            case VAL2:
                return 2;
            //case null:                               // illegal
        }
        return 0;                                      // несмостря на то что все элементы enum перебраны, компилятор требует
    }

    private static String getPart() {
        return null;
    }

    private enum MyEnum {
        VAL1,
        VAL2
    }
}
