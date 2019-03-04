package ru.roman.certification.classes.obscuring;

import java.lang.String;      // obscured by type declared bellow
import java.lang.*;

public class ObscuringExample {
    Integer String;

    void foo() {
        // new String("");    // illegal, java.lang.String obscured
        new String();

        String.valueOf(123);  // ObscuringExample.String type obscured by variable String это не static метод
                              // String а static метод Integer вызванный на переменной String типа Integer
                              // если переменную убрать, нескомпилится, т к у типа ниже нет такого метода
    }
    class String {}           // ok, nested можно и с импортом даже
}
//class String {}             // illegal т к если есть import, нельзя объявить top-level,
                              // но можно если только импорт всего пакета import java.lang.*;
