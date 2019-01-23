package ru.roman.samples.diff;

public class Extendings implements MyInterface {


    public void thierstMeth() {
        // TODO Auto-generated method stub
    }

    public void secondMeth(MyInterface param) {
    }

    public void thirdMeth() {
        new Extendings().secondMeth(new Extendings());
    }

    // при наследовании тип реализованный интерфейсом сохраняется ...
    public void fouthMeth() {
        new Extendings().secondMeth(new Extendings2());
    }

    public void firstMethod() {
    }

    class Extendings2 extends Extendings {
    }

    public static void main(String[] args) {
        new Extendings().fouthMeth();
    }
}
