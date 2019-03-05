package ru.roman.certification.classes.access;

import ru.roman.certification.classes.access.pkgbar.AllAccessTypesFoo;

class IndirectAccessClass extends AllAccessTypesFoo.IndirectAccessor {

    IndirectAccessClass() {
        new AllAccessTypesFoo().super();
    }

    @Override
    protected String fo() {
        return super.fo();
    }

    public static void main(String[] args) {

        IndirectAccessClass e = new IndirectAccessClass();
        System.out.println(e.fo());
    }
}
