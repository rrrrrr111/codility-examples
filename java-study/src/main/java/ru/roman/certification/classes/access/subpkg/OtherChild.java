package ru.roman.certification.classes.access.subpkg;

import ru.roman.certification.classes.access.Parent;

class OtherChild extends Parent {

    @Override
    public void publicMethod() {}

    //@Override                     // illegal
    void packagePrivateMethod() {}

    @Override
    protected void protectedMethod() {}

    //@Override                       // illegal
    private void privateMethod() {

        super.publicMethod();
        super.protectedMethod();
        //super.packagePrivateMethod();
        //super.privateMethod();      // illegal

        new Parent().publicMethod();
        //new Parent().protectedMethod();       // illegal protected доступен через super но не доступен через инстанс
        //new Parent().packagePrivateMethod();
        //new Parent().privateMethod();      // illegal
    }
}
