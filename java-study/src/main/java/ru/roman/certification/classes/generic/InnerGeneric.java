package ru.roman.certification.classes.generic;

class InnerGeneric {
}

class Seq<T> {
    class Zipper<S> {            // может юзать папараметр из outer класса
        Seq<Pair<T, S>> zip(Seq<S> that) {
            return null;
        }
        <T> Zipper(T t) {}       // конструктор зашадовил папараметр T из outer класса,
                                 // к зашадовленному никак теперь не достучаться
    }
    static class Pair<T, M> {}   // nested класс задает свой параметр T, не может юзать папараметр из outer класса
}



