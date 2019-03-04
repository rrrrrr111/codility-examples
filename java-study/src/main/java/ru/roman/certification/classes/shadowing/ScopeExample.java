package ru.roman.certification.classes.shadowing;

class Foo { void f2(String s) {} }
class Test {
    void f1(int i) {}
    void f2(int i) {}

    void m() {
        new Foo() {{                   // блок инициализации в анонимном классе
                f1(0);
                //f2(0);               // illegal, свой метод приоритетнее
                f2("");             // не счетается shadowing'ом, т к оба метода при декларации не пересекаются по скоупу
                Test.this.f2(0);
            }};
    }
}
