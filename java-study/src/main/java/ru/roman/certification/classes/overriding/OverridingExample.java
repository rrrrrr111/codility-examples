package ru.roman.certification.classes.overriding;

import java.io.Serializable;
import java.util.Collection;

abstract class BooGoo {

    @Override
    public abstract String toString();

    protected String help() {
        return super.toString();
    }
}

interface Boo {
    void foo1(Collection<String> list);
    void foo2(Collection list);
    <T extends String & Serializable> void foo3(Collection<T> list);

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
    //public abstract void foo2(Collection<Integer> list);   // illegal
    public abstract void foo2(Collection list);

    @Override
    //public abstract <T extends String & Serializable & Cloneable> void foo3(Collection<T> list);  // illegal
    public abstract void foo3(Collection list);

    public String toString() {
        return help();
    }

    public static void main(String[] args) {

        System.out.println(new OverridingExample() {
            public void foo1(Collection list) {}
            public void foo2(Collection list) {}
            public void foo3(Collection list) {}
        });
    }
}


