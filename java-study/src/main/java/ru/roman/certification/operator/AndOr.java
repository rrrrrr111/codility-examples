package ru.roman.certification.operator;

/**
 *
 */
public class AndOr {

    public static void main(String[] args) {


        boolean r = isFirst() && isSecond() || isFerd();


        System.out.println(r);
    }

    private static boolean isFirst() {
        System.out.print(1 + " ");
        return false;
    }

    private static boolean isSecond() {
        System.out.print(2 + " ");
        return false;
    }

    private static boolean isFerd() {
        System.out.print(3 + " ");
        return true;
    }
}
