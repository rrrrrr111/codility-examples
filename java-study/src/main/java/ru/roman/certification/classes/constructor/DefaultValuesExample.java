package ru.roman.certification.classes.constructor;

/**
 * 1. Поля инициализируются автоматически null/0/false
 *
 * 2. Локальные переменные не примитивного типа могут инициализироваться
 * присвоением null, не присваивая null они не инициализируются .. .
 *
 * 3. При объявлении переменных одного типа можно перечислить их через
 * запятую, можно также инициализироать их или нет ..
 *
 * 4. При ветвлениях if else, компилятор может проверить , инициализируется
 * ли переменная во всех ветвлениях if else, если нет то compile time error
 *
 * 5. Исходник можно писать в одну строку , если разделять выражения знаком ;
 *
 * @author дтоь 12.01.2008
 */
public class DefaultValuesExample {

    private static short aShort;
    private static int aInt = 000000000; // octal value
    private static long aLong;
    private static char aChar;
    private static byte aByte;
    private static float aFloat;
    private static double aDouble;
    private static boolean aBoolean;
    //private static void a9;           // void считается примитивом, но объявить его нельзя...
    private static String string;       // не примитив
    private static Short wShort;
    private static Integer wInteger;
    private static Long wLong;
    private static Float wFloat;
    private static Double wDouble;
    private static Boolean wBoolean;
    private static Character wCharacter;
    private static Byte wByte;
    private static Void aVoid;         // не примитив


    public static void main(String[] args) {

        byte x1, x2, x3;       // объявление одной строкой
        x1 = x2 = x3 = 3;      // инициализация одной строкой
        double x4 = 1E3, x5 = 0x1D, x6 = 01;       // объявление и инициализация одной строкой

        System.out.println("Primitives:" +
                " aShort=" + aShort + ", " +
                " aInt=" + aInt + ", " +
                " aLong=" + aLong + ", " +
                " aChar='" + aChar + "'=" + (int) aChar + ", " +
                " aByte=" + aByte + ", " +
                " aFloat=" + aFloat + ", " +
                " aDouble=" + aDouble + ", " +
                " aBoolean=" + aBoolean);
        System.out.println("Wrappers:" +
                " wShort=" + wShort + ", " +
                " wInteger=" + wInteger + ", " +
                " wLong=" + wLong + ", " +
                " wFloat=" + wFloat + ", " +
                " wDouble=" + wDouble + ", " +
                " wBoolean=" + wBoolean + ", " +
                " wCharacter=" + wCharacter + ", " +
                " wByte=" + wByte + ", " +
                " aVoid=" + aVoid + ", " +
                " string=" + string);
    }
}
