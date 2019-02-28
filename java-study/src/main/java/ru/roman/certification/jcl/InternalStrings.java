/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.jcl;

/**
 * 1. Метод .intern()  означает - сохранить строку в глоюольный пул строк, а в пуле строк
 * строки не сохраняются дважды (это проверяется)
 * соответстввенно метод нужно вызывать перед сравнение строк ,
 * чтобы результаты конкатенации не кешировались локально ..
 *
 * 2. строковые литералы всегда интернированы
 *
 * 3. Обрати внимание :
 * - при перечислении через точку классов , пакетов, полей,
 * всегда можно попутать поле и класс, поэтому поля всегда делают недоступными
 * извне...
 *
 * @author churganov_r 15.03.2011
 */
public class InternalStrings {

    public static void main(String[] args) {

        String a = "hello";
        String b = a;
        String hello = "Hello", lo = "lo";

        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println("hello" == new String("hello"));
        System.out.println("hello" == new String("hello").intern());

        System.out.println(hello == "Hel" + "lo");
        System.out.println(hello == "Hel" + lo);           //
        System.out.println((hello == ("Hel" + lo).intern()));

        System.out.println((hello == "Hello") + " ");       //

    }
}
