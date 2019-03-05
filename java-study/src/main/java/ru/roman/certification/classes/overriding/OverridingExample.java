package ru.roman.certification.classes.overriding;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

abstract class BooGoo {

    @Override
    public abstract String toString();

    protected String help() {
        return super.toString();
    }
}

interface Boo {
    void foo1(Collection<String> list);
    Iterable foo2(Collection list);
    <T extends String & Serializable> void foo3(Collection<T> list);
    <T extends String & Serializable> T foo4(Collection<T> list);

    @Override
    String toString(); // переопределение Object.toString() абстрактным методом, это ни к чему не обязывает наследников
                       // т к интерфейс требует его имплементировать, и т к любой кто его имплементит не явно наследуется
                       // от Object то у него уже будет этот метод наследован от Object
                       // однако если обявить такой абстрактный метод в абстрактном классе, то это обяжет наследников
                       // определить его у себя, при этом у них будет не доступно super.toString()
}

abstract class OverridingExample extends BooGoo implements Boo {

    @Override
    //public abstract void foo1(Collection<Integer> list);   // illegal
    public abstract void foo1(Collection list);              // можно переопределять только с row типом или с таким же женериком

    @Override
    //public abstract Iterable foo2(Collection<Integer> list);   // illegal
    public abstract Iterable<Integer> foo2(Collection list); //

    @Override
    //public abstract <T extends String & Serializable & Cloneable> void foo3(Collection<T> list);  // illegal
    public abstract void foo3(Collection list);

    @Override
    @SuppressWarnings("unchecked")
    public abstract String foo4(Collection list);     // return type not covariant

    public String toString() {
        return help();
    }

    public static void main(String[] args) {

        System.out.println(new OverridingExample() {
            public void foo1(Collection list) {}
            public Iterable foo2(Collection list) {return null;}
            public void foo3(Collection list) {}
            public String foo4(Collection list) {return null;}
        });
    }
}


class C<T> {      T id(T x) {return null;}    }
interface I<T> {  T id(T x);   }
class D extends C<Number> implements I<Number> {
    //public Number  id(Number x)  {return null;}                 // signature is different and is not a subsignature
    public Number id(Number x) {return null;}                 // overridden methods have the same erasure
}