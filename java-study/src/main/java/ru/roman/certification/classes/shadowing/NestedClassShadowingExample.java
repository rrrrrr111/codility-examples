package ru.roman.certification.classes.shadowing;

public class NestedClassShadowingExample {
}

class Foor {
    class Nested {}
}

class Pucki extends Foor {

    void foo(){
        new Nested();
    }

    class Nested {}
}
