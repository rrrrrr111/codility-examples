/*
 *
 */
package ru.roman.certification.classes;

import java.io.Serializable;

/**
 * 1. у методов любые модификаторы всегда идут перед возвращаемым методом типом
 *
 * @author churganov_r 19.03.2011
 */
public class A025_Classes {

    /**
     * 1. Нельзя объявить вложенные интерфейсы, классы или астрактные классы с
     * одинаковыми именами на одном уровне, а также нельзя вложить друг в друга
     * эти сущности с одинаковыми именами при любом уровне вложенности,
     * это правило также относится к классам вложенным внутри методов. Тоесть
     * нельзя в методе объявить класс с таким же именем у как владелеца метода
     *
     * 2. Можно вложить в 2 разных вложенных класса сущности с однаковыми
     * именами и это не будет ошибкой.
     *
     * 3. Можно объявить интерфейс static и abstract - но это не имеет смысла
     *
     * 4. Вложенный класс не может иметь статических мотодов, полей и блоков статических
     * инициализаций , вложенный класс может иметь статические методы, блоки
     * и поля только если он сам статический.
     * Это правило так же относится к абстрактным вложенным классам и
     * к классам внутри методов - тоесть они тоже считаются как вложенные
     *
     * 5. В статическом классе можно объявлять не статический метод, но тогда
     * он будет не доступен поскольку его вызов доступен только из статического
     * контекста, а вызов не статических методов из статического контекста не
     * допустим, хотя этот метод можно дернуть через рефлексию.
     *
     * 6. В интерфейсе для методов дотупны модификаторы только public и abstract,
     * причем эти модификаторы не имеют смысла и принимаются по умолчанию если
     * они не указаны.
     *
     * @author churganov_r 19.03.2011
     */
    public class A025_Classes1 {

        void foo() {
            class A025_Classes2 {
                int a;
                //static int b;                    //ошибка
                //class A025_Classes1 {            //ошибка
                //}
                //static void foo(){               //ошибка
                //}
            }
            //static class A025_Classes2 {         //ошибка
            //}
            //protected class A025_Classes2 {         //ошибка
            //}
        }

        class A025_Classes2 {
        }
    }

    public static class A025_Classes2 {

        static int i = 0;

        static {
        }

        static void foo() {
        }

        void foo1() {
            System.out.println("Привет");
        }
    }

    public abstract class A025_Classes3 {

        void foo() {
        }
    }

    public static abstract class A025_Classes4 {

        static void foo() {
        }
    }

    public interface A025_Interface1 {

        void foo();
    }

    public abstract interface A025_Interface2 {

        abstract void foo();
    }

    public static abstract interface A025_Interface3 {

        void foo();

        abstract void foo1();
    }

    void foo1() {


        /**
         *
         * 1. Класс внутри метода не может иметь модификатора доступа,
         * поскольку он все равно не доступен из вне
         *
         * 2. Внутри обычного метода недопустимо создвать интерфейсы и статические
         * сущности.
         *
         * 3. Внутри метода могут быть сущности с такими же именами
         * как у вложенных классов того же класса а так же могут быть
         * сущности с одинковыми именами например в разных методах
         *
         * 4. Внутри метода допустимо наследование и поэтому допустим
         * модификатор final для классов
         *
         * 5. Во вложенном классе допустимо использование только final переменных
         * и параметров, а если они final следовательно не допустима их модификация.
         * Работать с не final полями вложенный класс может
         *
         *
         */

        final int i = 0;
        class A025_Classes1 {
            void foo() {
                //i = 1;    // недопустимо
                System.out.println(i);   // допустимо


                new Serializable() {
                };  // допустимо
            }
        }

        //static class A025_Classes6 {
        //}

        abstract class A025_Classes3 {
        }

        // static abstract class A025_Classes8 {
        //}

        // interface A025_Interface4 {
        //}

        // abstract interface A025_Interface5 {
        //}

        // abstract static interface A025_Interface6 {
        //}
    }

    static void foo2() {


        /**
         *
         * 1. В статическом методе такие же ограничения как и в обычном
         *
         *
         *
         */
        class A025_Classes1 {
        }

        // static class A025_Classes2 {
        // }

        abstract class A025_Classes3 {
        }

        // static abstract class A025_Classes4 {
        // }

        // interface A025_Interface1 {
        // }

        // abstract interface A025_Interface2 {
        // }

        // abstract static interface A025_Interface3 {
        // }
    }

    //abstract void foo3();   - абстрактные методы не допустимы в не абстрактном классе


}

/**
 * 1. Статические сущности нельзя объявить в это же исходнике,
 * допустимы модификаторы только package, final, strictfp, abstract
 * у обычных классов модификатор static не доступен, обычный класс считается
 * статическим если все его методы статические
 *
 * 1.1 Такой класс виден в других классах этого пакета. Но если в
 * пакете будет еще один класс с таким именем , то будет VerifyError
 * при компиляции.
 *
 * 2. Сущности в этом же исходнике не могут быть public
 *
 * 3. Сущности в этом же исходнике могут иметь такие же имена как у вложенных
 * классов внутри других классов в этом же исходнике
 *
 * @author churganov_r 21.03.2011
 */
class A025_Classes1 {
}

//static class A025_Classes2 {
//}
abstract class A025_Classes3 {
}

// abstract class A025_Classes4 {
//}
interface A025_Interface1 {
}

abstract interface A025_Interface2 {
}
//public static abstract interface A025_Interface3 {
//}
