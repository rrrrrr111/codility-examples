package ru.roman.certification.classes.Inheritance;

class InheritanceExample extends Object {
}

interface I<T> {}

class B implements I<Integer> {}
// class C extends B implements I<String> {}         // illegal, хочет I<Integer> и I<String>


interface Fish {
    //int getNumberOfScales();
    Number get();
}

interface StringBass {
    //double getNumberOfScales();
    Integer get();
}

class Boo {
    public final static int pp = 1;
    static final void fazoo(){}
}

class Bass extends Boo implements Fish, StringBass {
    @Override
    public Integer get() {
        return null;
    }
    //public int getNumberOfScales() {return 0;}   // illegal

    public final static int pp = 1;
    //static final  void fazoo(){}               // illegal
}