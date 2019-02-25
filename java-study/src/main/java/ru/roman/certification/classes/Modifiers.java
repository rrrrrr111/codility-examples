/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.classes;

/**
 * 1. Модификаторы
 * public
 * package
 * protected
 * private
 *
 * transient - избегаемсриализации
 * volatile - сброс значения в кучу сразу при каждой записи
 *
 * native - реализация через JNI или системный метод JVM
 * abstract - абстарктный класс или метод
 * strictfp - строгий алгоритм мат вычислений с плавающей точкой
 * synchronized - доступен для одного одновременно потока только
 *
 * final - метод нельзя переопределить, переменную\поле переписать
 * static - статический метод, поле, класс
 *
 *
 * - для класса
 * public (package) protected private final static abstract strictfp
 * - для конструктора
 * public (package) protected private
 * - для метода
 * public (package) protected private final static abstract strictfp native synchronized
 * - для поля
 * public (package) protected private final static transient volatile
 * - для блока
 * - static или без модификатора - на уровне методов класса это равносильно
 * конструктору, блок статической инициализации выполнится при загрузке класса,
 * блок без static на уровне метода - блок обычной инициализации
 * - synchronized или без модификатора - внутри метода
 * - для переменной
 * final
 */
public strictfp abstract class Modifiers {

    private static transient final int a = 1;   // final поле всегда должно инициализироваться явно (константа)
    private transient final int с;          // не static должно инициализ во всех конструкторах, компилятор проверяет
    private static transient volatile int b;
    //private final volatile int bb;  // illegal

    // конструкторы можно дергать друг из друга и нельзя дергать из методов и блоков
    Modifiers() {
        //super();                    // должно быть первой строкой, можно явно не писать, компилятор вставляет по дефолту
        int h = 1;
        foo4();
        с = 1;
    }

    Modifiers(int i) {
        this();                          // должно быть первой строкой
        int h = 1;
        //с = 1;                         // компилятор ругается, уже определена
    }

    protected Modifiers(int i, int j) {         // тут this(); будет вставлено компилятором не явно
        с = 1;                                          // или super(); если бы this() не было
    }

    private Modifiers(int i, int j, int k) {    // тут this(); будет вставлено компилятором не явно
        с = 1;
    }

    static {
        // выполнится перед выполнение всего кода, если этот класс учавствует в коде
    }

    {
        // выполнится сразу перед конструктором этого класса, если блоков несколько они выполнятся по порядку
    }


    //  не abstract - допустимы только native либо strictfp и любые модификаторы доступа
    private final static native synchronized void foo1();

    private final static strictfp synchronized void foo2() {
        synchronized (new Object()) {
        }
    }

    //  abstract - допустимы только public либо protected
    protected abstract void foo4();

    public abstract void foo5();

    // классы могут быть либо final либо abstract
    // static - доступен только для вложенных классов, это сделано лдя того
    // чтобы такие класссы иницировались на стадии компиляции и были доступны
    // по сслыке на класс
    // у обычных классов модификатор static не доступен, обычный класс считается
    // статическим если все его методы статические,
    // Также любой класс можно рассматривать как статический если мы имеем дело
    // с его статическими методами

    // вложенный статический класс можно создать через ссылку на базовый следующим
    // образом new Modifiers.A021_Modificators1(), несмотря на то,что
    // класс static в нем можно объявить методы не static и получить к ним
    // доступ через интсанс класса, доступ к не static методам возможен просто
    // по ссылке на класс

    private final static strictfp class A021_Modificators1 {
    }

    private abstract static strictfp class A021_Modificators2 {
    }

    class Modifiers3 extends Modifiers {

        public void foo5() {
        }

        int foo() {
            return 0;
        }

        public void foo4() {
        }
    }

    public static void main(String[] args) {
    }

    private transient volatile Integer tra1 = 1;                       // OK

    abstract int foo();                                     // OK
}
/**
 * 1. Все модификаторы доступа актуальны для полей и методов, для классов
 * используются только package и public.
 * - для вложенных классов актуальны также protected и private
 * - модификатор доступа всегда должен идти первым, далее могут идти
 * другие модификаторы
 *
 *
 * 2. Если модификатор доступа не указан используется package, его легко спутать
 * с объвлением пакета
 * - package модификатор нормально компилируется для класса, для
 * методов , полей, конструкторов не может использоваться..
 *
 * 3. transient и volatile используются только полями и допустимо их совместное
 * использование
 *
 * 4.  native и abstract - методы не могут содержать тела
 *
 * 4.1 native и synchronized - модификаторы только для методов, synchronized
 * может использоваться еще для блоков
 *
 * 5. strictfp и abstract - модификаторы только для классов и методов
 *
 * 6. abstract совместим только с protected public и package
 *
 * 7. strictfp и native не совместимы
 */
