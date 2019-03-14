package ru.roman.certification.classes.nested;

class ThisSuperExample {

    ThisSuperExample() {}

    class InnerSham { //extends ThisSuperExample {
        InnerSham() {
            super();
        }
    }
    class InnerShanTaram extends InnerSham {
        InnerShanTaram() {
            ThisSuperExample.this.super();  // передаем инстанс обрамляющего класса на вызов конструктора суперкласса
        }
    }

    static class InnerBarabah extends InnerSham {
        InnerBarabah() {
            new ThisSuperExample().super();  // передаем инстанс обрамляющего класса на вызов конструктора суперкласса
        }
    }
}
