/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.naming;

/**
 * 1. Переменнае объявляются как имяПеременной
 * 2. Идентификаторы классов как НекоторыйКласс
 * 3. константы как НЕКОТОРАЯ_КОНСТАНТА
 * - компилятор проверяет чтобы константа была задана, иначе будет ошибка ..
 * - Поскольку константы объявляются как final и нельзя скомпилировать класс не
 * инициализировав константу, то получается модиификатор static - не нужен,
 * за исключением того что static будет загружен единожды при старте системы
 * - константа должна быть всегда инициализирована явно,
 * и не может быть инициализирована автоматически поскольку автоматическая
 * инициализация не возможна при модификаторе final
 *
 * 4. Идентификатор может содержать буквы , цифры, подчеркивание и символ валюты, но не может начинаться с цифры.
 * Это правило относится также к именам пакетов, классов и проч.
 *
 * @author churganov_r 16.03.2011
 */
public class Naming {

    boolean boolVarable;
    public static final boolean SOME_CONSTANT = false;
    //public static final boolean SOME_CONSTANT;  worse
    final int GREEN_COLOR = 2;


    private static String __$123abc;              // корректные идентификаторы
    private static String $___123abc;
    private static String a_b$c;


}
