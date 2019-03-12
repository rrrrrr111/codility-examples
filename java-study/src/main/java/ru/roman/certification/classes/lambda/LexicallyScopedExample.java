package ru.roman.certification.classes.lambda;

import java.util.function.Consumer;

/**
 *
 */
class LexicallyScopedExample {

    public int x = 0;
    public int z = 0;

    abstract class AbstractLevel {
        public int x = 666;
    }

    class FirstLevel extends AbstractLevel {

        public int x = 1;
        public int z = 1;

        void methodInFirstLevel(int x) {

            //x = 99;  // local variables referenced from a lambda expression must be final or effectively final

            Consumer<Integer> myConsumer = (y) -> {
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                System.out.println("z = " + z);
                System.out.println("this.x = " + this.x);
                System.out.println("LexicallyScopedExample.this.x = " + LexicallyScopedExample.this.x);
                System.out.println("AbstractLevel.x = " + super.x + " " + ((AbstractLevel)this).x + " " + FirstLevel.super.x);
            };

            myConsumer.accept(x);


            MyCons v = (d) -> {};

        }
    }

    public static void main(String... args) {
        LexicallyScopedExample st = new LexicallyScopedExample();
        LexicallyScopedExample.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }

    @FunctionalInterface
    interface MyCons {
        int d = 67;

        void boo(int d);

        String toString();
    }
}
