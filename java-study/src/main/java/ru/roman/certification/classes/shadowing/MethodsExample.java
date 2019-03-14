package ru.roman.certification.classes.shadowing;

import static ru.roman.certification.classes.shadowing.Food.toFoo;
import static java.util.Arrays.toString;

class MethodsExample {

    public void gg() {

        Food.toFoo(new Object());
        toFoo(new Object());
        toFoo(1);

        //toString(1);      // illegal, шадовится методом Object.toString()
    }

    //void toFoo(int i) {}  // шавдовит импорт, сразу все overloaded методы
}
