package ru.roman.certification.classes.constructor;

class ClassLoadingDeadlock {

    public static void main(String[] args) {
        new First();                                    // загрузим класс и инициализируем его
    }

    static class First extends Second {
        static {                                        // вызывается первым т к этот класс загружен первым
            System.out.println("1. " + First.s);        // 0
        }
        final static int s = Second.foo();              // надо подгрузить второй класс и дернуть метод
        static int foo() {
            System.out.println("3. " + s);              // 0 дернуто из второго класса
            return s + 1;
        }
        static {
            System.out.println("6. " + s);              // 2 догружаем первый
        }
    }
    static class Second {
        static {
            System.out.println("2. " + Second.s);       // 0 вызывается ыторым, подгрузка второго класса
        }
        final static int s = First.foo();               // дернем метод из первого класса
        static int foo() {
            System.out.println("5. " + s);              // 1 вызов метода из первого класс
            return s + 1;
        }

        static {
            System.out.println("4. " + s);              // 1 догружаем второй класс
        }
    }
}
