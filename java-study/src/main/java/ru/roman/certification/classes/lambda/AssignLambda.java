package ru.roman.certification.classes.lambda;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.DoubleFunction;
import java.util.function.Function;

class AssignLambda {

    public static void main(String[] args) throws Exception {
                                                    // Variable declarations
        Callable<Double> r6 = () -> 0.0;
        // Object r7 = () -> 0.0;                   // illegal, LE/MR приводится только к FI
        Object r7 = (Callable<Double>)() -> 0.0;    // Cast expression ok
        Function<Integer, Double> r1 = i -> 0.0;
        Function<Integer, Double> r2 = Math::atan;
                                                    // Assignments
        r1 = i -> 0.0;
        r2 = Math::sqrt;
        //r2 = Math::abs;   // illegal, у Math::abs перегруж методы, типы соотв функиций Function<Integer, Integer>,
                            // Function<Double, Double> и т п но Integer в Double никак не может быть конвертировано

        class Foo{                  // Return statements
            Function<Integer, Double> foo1() { return i -> 0.0; }   // вроде выглядит как передача LE, но это return LE
            Function<Integer, Double> foo2() { return Math::sqrt; }
        }
                                                    // Array initializers
        Function<Integer, Integer>[] r4 = new Function[]{i -> 0.0, i -> i.toString()};  // non reifiable type
                                   // для LE без указания типа параметра компилятор пытается заинферить тип исходя из
                                   // FI в который оно преобразуется, т к FI здесь generic, и мы указали Row тип,
                                   // т к при создании массива generic типа нельзя указать параметры типа, то тип
                                   // параметра LE определяется как Object, т е LE без типа параметров, в этом
                                   // смысле универсальнее чем MR
        //Function<Integer, Integer>[] r5 = new Function[]{(int i) -> 0.0};  // illegal, expected Object, found int
        //Function<Integer, Integer>[] r = new Function[]{Math::sqrt};  // illegal, Object is not convertible to double

        DoubleFunction<Integer>[] r10 = new DoubleFunction[]{Math::sqrt}; // хотя sqrt вернет double, тут Integer non reifiable type
        //var s = r10[0].apply(1).toString(); // ClassCastException: class Double cannot be cast to class Integer
                                                // хотя мы дернули метод который есть у Double, компилятор уже вставил
                                                // преобразование к Integer

        List.of(.1).forEach(i -> i++);    // Method or constructor arguments
        List.of(1.).forEach(Math::abs);

                                          // Lambda expression bodies,
        Callable<Callable<Callable<Double>>> r8 = () -> () -> () -> 0.;
        boolean r11 = r8.call().call().call().isNaN();      // false

                                          // Conditional expressions ( ? : )
        Runnable r = true ? () -> {} : () -> {};

        System.out.println(r);
    }
}
