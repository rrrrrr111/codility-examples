package ru.roman.certification.classes.shadowing;

import static ru.roman.certification.classes.shadowing.Food.toFoo;

class MethodsExample {

    public static void main(String[] args) {

        Food.toFoo(new Object());
        toFoo(new Object());
    }

    //static void toFoo(int i) {}  // шавдовит импорт, сразу все overloaded методы
}
