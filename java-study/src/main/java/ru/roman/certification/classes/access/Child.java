package ru.roman.certification.classes.access;

public class Child extends Parent {

    @Override
    public void publicMethod() {}

    @Override
    void packagePrivateMethod() {}

    @Override
    protected void protectedMethod() {}

    //@Override                       // illegal, это не переопределение а дублировани метода
    private void privateMethod() {

        super.publicMethod();
        super.protectedMethod();
        super.packagePrivateMethod();
        //super.privateMethod();      // illegal

        new Parent().publicMethod();
        new Parent().protectedMethod();       // protected доступен, но только потому что класс в том же пакете
        new Parent().packagePrivateMethod();
        //new Parent().privateMethod();      // illegal
    }
}
