package ru.roman.certification.classes.generic;

import static ru.roman.certification.classes.generic.TigerThrower.sneakyThrow;

/**
 *
 */
class BrokenType {

    public static void main(String[] args) {

        sneakyThrow(new Throwable());
    }
}

class TigerThrower {

    static <T extends Throwable> void sneakyThrow(Throwable t) throws T {
        throw (T) t;
    }
}


class Thrower {
    public static void main(String[] args) {
        Integer foo = foo(123);   // ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer
        System.out.println(foo);
    }


    static <T> T foo(T val) {
        class Bogo extends RuntimeException {
            final T f;

            private Bogo(T f) {
                this.f = f;
            }
        }

        if ("1" == val) {
            throw new Bogo(val);
        } else {
            try {
                foo("1");
            } catch (Bogo b) {
                val = b.f;
            }
        }
        return val;
    }
}

class Hjjj<M> {

    // class Nmm extends RuntimeException{  }    // illegal

}