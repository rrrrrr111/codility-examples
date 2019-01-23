/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.primitives;

/**
 * 1. Есть ряд зарезервированных ескейп последовательностей.
 *
 * 2. Ескейп поледовательности при компиляции автоматически подменяются на
 * соответсттвующие символы и далее интерпретируются соответственно .. .
 * это значит что некоторые, например \u000A - нельзя использовать .. .
 *
 * 3. Если сложить 2 char символа, то прсто сложатся их коды
 *
 * @author churganov_r 17.03.2011
 */
public class EscapeSequences {

    char f1 = 0x08;
    char f2 = '\b';  // Забой (backspace)   	\u0008
    char f21 = '\u0008';
    char f22 = '\u005C\u0062';  // или так

    char f3 = '\t';  // табуляция (horizontal tab)  \u0009
    char f31 = '\u0009';
    char f32 = '\u005C\u0074';  // или так

    char f4 = '\n';     // Перевод строки (linefeed)  \u000A
    char f41 = '\u005C\u006e';       //только так по иному не дает задать ни даже в комментарии указать ..
    // эскейп последовательности интрепретируются компилятором
    // в первую очередь поэтому эскейп последовательность символа
    // перевода строки сразу преобразуется в фактический перевод строки

    char f5 = '\f';         //Перевод страницы (form feed) \u000C
    char f51 = '\u005C\u0066';  //только так по иному не дает задать ни даже в комментарии указать ..

    char f6 = '\r';     // Возврат каретки (carriage return)  \u000D
    char f61 = '\u005C\u0072';  //только так по иному не дает задать ни даже в комментарии указать ..

    char f7 = '\"';    //Двойная кавычка (double quote) \u0022
    char f71 = '\u0022';            // так
    char f72 = '\u005C\u0022';      // или так

    char f8 = '\'';     //Апостроф (single quote)  \u0027
    char f81 = '\u005C\u0027';  // только так

    char f9 = '\\';     //Обратная косая черта (backslash) \u005C
    char f91 = '\u005C\u005C';  // только так


    void foo() {
        System.out.println(f1 + "|" + f2 + "|" + f21 + "|" + f22);
        System.out.println(f3 + "|" + f31 + "|" + f32);
        System.out.println(f4 + "|" + f41);
        System.out.println(f5 + "|" + f51);
        System.out.println(f6 + "|" + f61);
        System.out.println(f7 + "|" + f71 + "|" + f72);
        System.out.println(f8 + "|" + f81);
        System.out.println(f9 + "|" + f91);

        System.out.println('c' + 'r'); // складываются их числа

        System.out.println("|" + '\177' + "\177" + '\uuuuuuuuuuu0177'); // пробельный символ

        System.out.println(">>>\uuuuuuuuuu006e \u006e<<<"); // один знак u можно использовать
        // также для выражения последобавтельности символов например для
        // формирования ключевого слова, несколько знаков u означают,
        // что последователность всегда будет использоваться на втором этапе
        // компиляции


    }

    public static void main(String[] args) {
        new EscapeSequences().foo();
    }
}
