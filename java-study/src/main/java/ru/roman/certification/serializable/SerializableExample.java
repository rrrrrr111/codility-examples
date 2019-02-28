/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.serializable;

/**
 * 1. Интерфейс служит толь для обозначения, что класс можно сериализовать,
 * это обозначение для фреймворков которые могут работать с сериализацией
 * классов.
 *
 * 2. static final не сериалицуются, но serialVersionUID всегда сериализуется,
 * тоже. это нужно длятого чтобы при десериализации проверить, что десериализо
 * вался нужный класс, если serialVersionUID в классе не задан, то он генеррируется
 * автоматически и кладется в класс, при десериализации он тоже автоматически
 * генерится и сравнивается с тем, что записан в классе. Таким образом, это
 * вызывает некоторые особенности:
 * - разные JRE могут по разному генерить serialVersionUID (возможны поэтому ошибки)
 * - при малейшем изменении класса (типа поля или модификатора метода)
 * serialVersionUID тоже будет меняться...
 * - строго рекомендуется принудительно указывать serialVersionUID в программе
 * - если указан serialVersionUID мы можем запретить использовать программе
 * старые классы поменяв serialVersionUID на новый.., или наоборот заставить работать с новыми
 *
 * @author churganov_r 21.03.2011
 */
public class SerializableExample implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

}
