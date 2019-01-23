/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.primitives;

/**
 * http://www.znannya.org/?view=Java_PrimitiveTypesOp
 *
 * 1. В Java, как и в языке C, преобразования типов при вычислении выражений
 * могут выполняться автоматически, либо с помощью оператора приведения типа.
 * Однако правила приведения типов несколько отличаются от правил языка C, и в
 * целом являются более строгими, чем в языке C.
 *
 * 2. При выполнении операции присваивания преобразование типов происходит
 * автоматически:
 * - если происходит расширяющее преобразование (widening conversion)
 * - два типа совместимы.
 * byte -> short -> int -> long -> float -> double.
 *
 * 3. Числовые типы не совместимы с типами char и boolean для преобразоваий
 * Типы char и boolean не совместимы также и друг с другом.
 *
 * 4. В языке Java выполняется автоматическое преобразование типов также и при
 * сохранении литеральной целочисленной константы (которая имеет по умолчанию тип
 * int) в перемен­ных типа byte, short или long (однако если литерал имеет
 * значение вне диапазона допустимых значений для данного типа, выдается сообщение
 * об ошибке: возможная потеря точности).
 *
 * 5. Если преобразование является сужающим (narrowing conversion), т. е.
 * выполняется преобразование
 * byte <- short <- char <- int <- long <- float <- double, то такое
 * преобразование может привести к потере точности числа или к его искажению.
 * Поэтому при сужающих преобразованиях при компиляции программы выводится
 * диагностическое сообщение о несовместимости типов и файлы классов не создаются.
 *
 * 6. Если все же необходимо выполнить сузжающие преобразования, используется операция
 * приведения (cast) типа, которая имеет следующий формат: (тип-преобразования) значение
 *
 * 7. Если значение с плавающей точкой присваивается целому типу, то (если значение
 * с плавающей точкой имеет дробную часть) при явном преобразовании типа происходит
 * также усечение (truncation) числа.
 *
 * 8. Если же присваиваемое значение лежит вне диапазона типа-преобразования, то
 * результатом преобразования будет остаток от деления значения на модуль диапазона
 * присваиваемого типа (для чисел типа
 * byte модуль диапазона будет равен 256 (|мин. значение | + макс. значение + 1(ячейка под ноль))
 * short    – 65536,
 * int      – 4294967296
 * long     – 18446744073709551616
 *
 * 9. При преобразовании целых или вещественных чисел в данные типа char,
 * преобразование в символ происходит, если исходное число лежит в диапазоне от
 * 0 до 127, иначе символ получает значение '?'.
 *
 * 10. При выполнении арифметических и побитовых преобразований все значения byte
 * и short, а также char расширяются до int, (при этом в вычислениях для char
 * используется числовое значение кода символа) затем, если хотя бы один операнд
 * имеет тип long, тип целого выражения расширяется до long. Если один из операндов
 * имеет тип float, то тип полного вы­ражения расширяется до float, а если один
 * из операндов имеет тип double, то тип результата будет double.
 *
 * 11. вещественные константы по умолчанию имеют тип double
 *
 * 12. Автоматические расширения типов (особенно расширения short и byte до int)
 * могут вызывать плохо распознаваемые ошибки во время компиляции. Например, в операторах:
 * byte x = 30, y = 5;
 * x = x + y;
 * перед выполнением умножения значение переменных x и y будет расширено до int,
 * а затем при выполнении попытки присвоения результата вычисления типа int переменной
 * типа byte будет выдано сообщение об ошибке.
 * Чтобы этого избежать надо использовать во втором операторе явное преобразование типов:
 * x = (byte) (x + y);
 * Выражение x + y необходимо заключит в скобки потому, что приоритет операции
 * приведения типа, заключенной в скобки, выше, чем приоритет операции сложения.
 * Кстати, если записать второй оператор в виде:
 * x += y;
 * то сообщения об ошибке не будет, в комбинированных операторах происходит автоматическое преобразование типа
 *
 * @author churganov_r 21.03.2011
 */
public class TypeConversion {

    public static void main(String[] args) {

        //short a = 1234121231;  // компилятор проверяет величину и не дает компилить
        //short b = 1.1;        // по умолчанию литерал превращается в double и компилятор не дает компилить
        byte e = 123;       // автоматическое преобразование int в byte
        //byte e1 = 1234;       // автоматическое преобразование int в byte не идет, слишком большой int и компилятор не дает компилить
        short с = 12341;        // автоматическое преобразование int в short
        int f = 345;
        long g = 345;            // автоматическое преобразование int в long

        //float h = 2345.34;      // компилятор обнаруживает сужжение и не дает компилить (double B float)
        float i = 2345.34f;        //  а тут не ругается. ..
        double d = 12341;       // автоматическое преобразование int в double

        char j = 45;                // автоматическое преобразование литерала int катит
        //j = e;                    // автоматическое преобразование переменных не катит ни для одного типа
        byte l = 'g';             // прокатывает автоматическое преобразование
        boolean k = true;

        //с = d;        // компилятор обнаруживает сужжение и не дает компилить
        //с = j;        // компилятор обнаруживает сужжение и не дает компилить

        с = (short) d;        // принудительный cast convertion катит, здесь также truncation (усечение)
        f = (int) i;
        System.out.println(с + " " + f + " " + l);

        с = (short) j;        // принудительный cast convertion катит для char
        //с = (short)k;        // принудительный cast convertion не катит для boolean

        j = (char) d;              // не известный символ отображается как ?
        System.out.println(с + " " + j + " " + l);

        byte x = 30, y = 5;
        //x = x + y;   // компилятор обнаруживает сужжение и не дает компилить
        x += y;        // прокатывает
        //byte x2 = 123 + 123; //результатом сложения будет int, компилятор обнаруживает сужжение и не дает компилить
        byte x2 = (byte) (1023 + 123); //результатом сложения будет int, все ОК и происходит  truncation

        byte b1 = 121;
        byte b2 = 122;
        //byte x3 = b1 + b2; //результатом сложения будет int, компилятор обнаруживает сужжение и не дает компилить
        int x4 = 1023123123 + 1231231231; //результатом сложения будет слишком большой int, все ОК и происходит truncation
    }
}
