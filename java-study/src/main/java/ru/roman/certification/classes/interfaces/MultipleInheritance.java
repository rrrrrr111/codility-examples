package ru.roman.certification.classes.interfaces;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 */
abstract class MultipleInheritance extends Abba implements Intf1, Intf2 {

    @Override
    public void foo() {
    }

    @Override
    public void def() {
        try {
            Intf2.super.def();
            Intf1.super.def();

            Intf2.sta();
            Intf1.sta();

            var v = Intf2.CONST;
        } catch (SQLException | IOException e) {}
    }

    @Override
    public abstract void def2();
}

abstract class Abba {
    public abstract void def3();
}

interface Intf1 {
    int CONST = 1;
    void foo() throws IOException;
    default void def() throws IOException {
        foo();
        def2();
    }
    default void def2() throws IOException {}
    void def3();
    static void sta() {}
}

interface Intf2 {
    int CONST = 2;
    void foo() throws SQLException;
    default void def() throws SQLException {}
    default void def2() throws SQLException {}
    default void def3(){}
    static void sta() {}
}

interface MultipleInheritanceIntfs extends Intf1, Intf2 {

    @Override
    default void foo(){}
    @Override
    void def();
    @Override
    void def2();
    @Override
    default void def3() {}
}
