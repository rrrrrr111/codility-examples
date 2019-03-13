package ru.roman.certification.classes.shadowing;

import static ru.roman.certification.classes.shadowing.Food.toFoo;

class MethodsExample {

    public void gg() {

        Food.toFoo(new Object());
        toFoo(new Object());
        toFoo(1);
    }

    //void toFoo(int i) {}  // шавдовит импорт, сразу все overloaded методы
}
