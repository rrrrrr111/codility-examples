package ru.roman.certification.classes.interfaces;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 */
class MultipleInheritance implements Intf1, Intf2 {

    @Override
    public void foo() {
    }
}

interface Intf1 {
    void foo() throws IOException;
}

interface Intf2 {
    void foo() throws SQLException;
}


