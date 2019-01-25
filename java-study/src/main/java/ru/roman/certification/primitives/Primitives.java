/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.primitives;

import static ru.roman.certification.util.ReplUtil.evaluate;

/**
 * 1. String не является примитивом, всего примитивов 8
 *
 * 2. Примитив - это ссылка на место в памяти где хранится значение
 *
 * 3. Одинаковые примитивы не хранятся в памяти , если два примитива
 *
 * имеют одно значение, то их ссылки смотрят в одно место, тоесть сравнивать их
 * можно оператором ==
 *
 * 4. Существует также специальный нулевой тип, тип выражения
 * null, который не имеет имени, он не имеет класса обертки и вроде примитивом
 * не является..
 *
 * 5. Есть еще тип void - имеет класс обертку и вроде примитивом не является..
 *
 * 5.1 В Java есть ссыочные типы и примитивные типы ..
 *
 * 6. Ссылочные типы – это типы
 * - классов,
 * - интерфейсов
 * - массивов.
 *
 * 7. переменная примитивного типа всегда содержит значение переменной
 * указанного типа, в отличии от ссылочной переменной
 *
 * 8. При указании литерала примитивного значения можно указать тип значения, например
 * 34L - , в этом случае мы принудительно указываем тип значения,
 *
 * 9. Языки типа JScript - интерпретирующего типа как правило являются языками
 * со свободной типизацией ..(loose typed language)
 *
 * 10. Языки компилирующего типа как Java являются как правило языками со
 * строгой типизацией . ..(strongly typed language)
 *
 * 11. Тип
 * - ограничивает набор значений, которые могут быть присвоены переменной,
 * - либо получены в выражении,
 * - ограничивает операции над значениями
 * - определяет реализацию конкретной операции.
 *
 *
 * 12. Целочисленные константы могут задаваться в программе одним из трех способов:
 * - в виде десятичных,        1
 * - шестнадцатеричных         0х1
 * - восьмеричных значений.    01
 *
 * 13. По умолчанию все числа интерпретируются как десятичные и относятся
 * к типу int
 *
 * 14. Явно указать принадлежность к типу можно, добавив в конце числа букву
 * "l"("L"), "d"("D"), "f"("F").
 * - эти буквы нужны чтобы компилятор не ругался при проверке числа, если
 * оно например слишком большое для int
 * - float вообще нельзя определить без буквы f
 *
 * 15. Шестнадцатеричное значение задается с помощью символов "0x" или "0X",
 * за которым значение числа (цифры 0-9 и буквы A-F или a-f), например: 0x7FFF.
 *
 * 16. Число в восьмеричной записи должно начинаться с нуля, за которым следует
 * одна или несколько восьмеричных цифр, например 077777.
 *
 * 17       10000   = -0x80
 * 11111   = -0x80 - -1
 * 11110   = -0x80 - -2
 * 10001   = -1
 * 00000   = 0
 * 00001   = 1
 * 01111   = 0x7F
 *
 * 18 Символы в Java реализованы с использованием стандарта Unicode.
 * Можно задать константу-символ в про­грамме или как обычный символ.
 * - Символьное значение должны быть заключено в пару одиночных апострофов, например
 * char symbol='f';
 * - Другой способ записи символов: пара символов u, за которой следует
 * четырехзначное шестнадцатеричное число (в диапазоне от 0000 до FFFF),
 * представляющее собой код символа в Unicode, например
 * char symbol = '\u0042';  // и только в одинарных кавычках
 * если таким образом задававать символы - ескейп последовательности.
 * то нужно указывать оба символа ескейп последовательности тоесть так
 * char f91 = '\u005C\u005C';
 * - можно также сделать вот так
 * char symbol = 0x42; // и это тоже самое
 * - спец символы типа char задаются специальными escape последовательностями..
 *
 * 19 Если мы говорим char a4 = 0x434;
 * это не то самое что char a4 = 434;
 * т к по умолчанию литерал числа воспринимается как десятичное число ..
 *
 *
 * 20 У Double и Float целая часть от мантисы отделяется точкой
 *
 * 21 число -3,58 на десять в седбмой можно также записать как –3.58E7
 * а число 73,675 на 10 в минус петнадцатой как 73.675e-15,
 * у 16-ричного числа e меняется на p т.к. e - в 16-ричной системе это цифра
 *
 * 22 Переменные с плавающей точкой могут хранить не только численные значения,
 * но и любой из особо определенных флагов (состоянии):
 * - отрицательная беско­нечность,
 * - отрицательный нуль,
 * - положительная бесконечность,
 * - положительный нуль
 * - «отсутствие числа» (not-a-number, NaN).
 *
 * 23 Все константы с плавающей точкой подразумеваются принадлежащими к типу
 * double. Чтобы задать число типа float, необходимо добавить в его конец
 * символ "f" или символ "F".
 * - Литерал в целой часть равной нулю можно обозначить как .5 например вместо
 * 0.5
 *
 * 24 Большинство операций над примитивными типами выполняется не с помощью
 * методов, а с помощью специальных символов, называемых знаком операции.
 *
 * 25 Переменные булевского типа (логические переменные) могут принимать одно
 * из двух значений: «истина» или «ложь»
 * В отличие от C, где результату «ложь» сопоставлено целое значение типа int
 * равное 0, а результату «истина» – ненулевое значение типа int , тоесть 1, 2 ,
 * - 1 и т п ..., и соответственно, результатам сравнения присваивается целое
 * значение (обычно 0 или 1), в Java для булевских переменных введен свой,
 * отдельный тип данных boolean
 *
 * 26 Действия с булевыми типами
 * - инициализация
 * - операции сравнения, арифметические и др.
 * - вывод в консоль
 *
 * @author дтоь 12.01.2008
 */
public class Primitives {

    // числовые типы
    // целые типы           размер      мин                 макс
    static byte a5;         //8         -128                127         знаковый
    static short a1;        //16       -32768               32767       знаковый
    static int a2;          //32       -2147483648          2147483648  знаковый
    static long a3;         //64       -922372036854775808  922372036854775807  знаковый

    static char a4;         //16        0                   65536       беззнаковый

    // числовые типы
    // вещественные типы                                        точность
    static float a6;        //32        3,4e-38 < |x| < 3,4e38      7-8 цифр
    static double a7;       //64        1,7e-308 < |x| < 1,7e308    17 цифр
    //булевский тип
    static boolean a8;      //8         true/false

    public static void main(String[] args) {

        short aShort = 12312;
        int aInt;
        long aLong;
        char aChar;
        byte aByte;
        float aFloat;
        double aDouble;
        boolean aBoolean;

        // 1 При сравнении литералы приводятся к значению в int
        evaluate("34.00000000000000D == 34L", 34.00000000000000D, 34L);
        // 2 Для  float и double признаки 8-ричной и 16-ричной системы игнорятся
        evaluate("034F == 34", 034F, 34);
        // 3 У char после \\u указывается 16-ричный символ, в операциях char приводится к числу
        evaluate("0x434 == '\\u0434'", 0x434, '\u0434');
        // 4 double и float Java хранит в виде записи типа значение * 10 в степени ...,
        // поэтому поддерживаются очень большие значения, но число по факту округляется,
        // поэтому не работает сравнение и арифметические операции не точны
        evaluate("34444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444d == 3444444444444444444l", 34444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444d, 3444444444444444444l);
        // 5
        evaluate("34444444444444444444444444444444444444f == 34444444444444444444444444444444444444d", 34444444444444444444444444444444444444f, 34444444444444444444444444444444444444d);
        // 6 у вещественного типа есть отрицательный ноль
        evaluate("-0d == 0d", -0d, 0d);
        // 7 у целого нет
        evaluate("-0 == 0", -0, 0);
        // 8 операции над вещественными типами происходят несколько иначе, на выходе можно получить например -Infinity
        // если хотябы один из операндов double, второй тоже Java приводит к double
        evaluate("-0x1e-1022f / 0l", -0x1p-1022d, 0l);
        // 9
        evaluate("1l / 0l", 1l, 0l);
        // 10 при вычислении Java делает автоматические преобразования к большему типу
        // но
        // !!! Если результат вышел за пределы long, то излишок отбрасывается
        // и результат может зайти в зону отрицательных значений
        evaluate("short aShort = 12312; long aLong = 1111111111111111111L * aShort;aLong", 1111111111111111111L, aShort);
        // 11
        evaluate("int aInt = 999999999 * 999999999;aInt", 999999999, 999999999);
        // 12 Java может преобразовать большое число в маленькое, при этом отбросит лишнее
        evaluate("int aInt = (int)999999999999999.567d * 444444444;aInt", 999999999999999d, 444444444);
        // 13
        evaluate("434 == '\\u0434'", 434, '\u0434');

        float x1 = 3.5f, x2 = 3.7E6f, x3 = -1.8E-7f, x4 = 0x1e;
        double z1 = 1.0, minus2e1 = -2e1, minus0x2p2 = -0x2p2;
        // Для десятичных чисел используется е - 2e1  2 умножить на 10 в первой степени
        // У hex чисел e является цифрой поэтому используют - p
        //    0x2.0p2 - 0x2.0 на два во второй степени
        // результат всегда выражается в Double


        System.out.println(z1 + " minus2e1=" + minus2e1 + " minus0x2p2=" + minus0x2p2);

        // System.out.println(017.00 + " " + 017 + " " + 0x017.00);
        // литералы float и doble не воспринимаются в восьмиричном
        // и шестнадцатиричном контексте и всегда интерпретируются как десятиричные


    }


}