package ru.roman.certification.classes.access;

import ru.roman.certification.classes.access.pkgbar.AllAccessTypesFoo;

class IndirectAccessClass extends AllAccessTypesFoo.IndirectAccessor {

    IndirectAccessClass() {
        new AllAccessTypesFoo().super();    // вызов конструктора родительского inner класса c передачей ему ссылки
                                            // на его outer класс
    }

    @Override
    protected String fo() {
        return super.fo();                 // тут может быть indirect доступ к приватным полям инстанса outer класса
    }

    public static void main(String[] args) {

        IndirectAccessClass e = new IndirectAccessClass();
        System.out.println(e.fo());
    }
}
