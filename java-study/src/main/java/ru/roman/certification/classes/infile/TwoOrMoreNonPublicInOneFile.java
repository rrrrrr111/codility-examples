/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.classes.infile;

/**
 * - В одном файле может быть много классов, при этом public класс может быть только один
 * <p>
 * - В файле может быть много не public классов и ни одного public, и они все по имени
 * могут не совпадать с именем файла, или один их них может совпадать, public класс всегда
 * должен иметь такое же имя как файл.
 *
 * @author Роман 19.01.2008 JDK 1.5
 */
class Foo {
}

abstract class Bar extends Object {
}

strictfp class Bazz {
}

final class BaaAazz {
}