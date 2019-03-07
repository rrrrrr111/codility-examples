package ru.roman.certification.operator;

/**
 *
 */
class OperationOrder {
    public static void main(String[] args) throws Exception {

        //int i = 1 / (0 * throwException());  // Exception
        //int i = 1 / 0 * throwException();     // ArithmeticException
        //int i = one() + zero() * five();       // 1 0 5
        //int i = one() + zero() * -~-~-~-five();   1 0 5
        int i = four() + one() / two() / (three() + zero());   // 4 1 2 3 0

        System.out.println("= " + i);
    }

    static int throwException() throws Exception {
        throw new Exception("Shuffle off to Buffalo!");
    }

    static int zero() {
        System.out.print("0 ");
        return 0;
    }

    static int one() {
        System.out.print("1 ");
        return 1;
    }

    static int two() {
        System.out.print("2 ");
        return 2;
    }

    static int three() {
        System.out.print("3 ");
        return 3;
    }

    static int four() {
        System.out.print("4 ");
        return 4;
    }

    static int five() {
        System.out.print("5 ");
        return 5;
    }
}
