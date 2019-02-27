package ru.roman.certification.classes.access;

import ru.roman.certification.classes.access.pkgbar.AllAccessTypesFoo;

public class IndirectAccessClass extends AllAccessTypesFoo.IndirectAccessor {

    private void fo() {
        //var v = super.privateStaticField;
    }

    public static void main(String[] args) {
    }
}
