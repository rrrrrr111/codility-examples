package ru.roman.certification.access;

import ru.roman.certification.access.pkgbar.AllAccessTypesFoo;

public class IndirectAccessClass extends AllAccessTypesFoo.IndirectAccessor {

    private void fo() {
        //var v = super.privateStaticField;
    }

    public static void main(String[] args) {
    }
}
