package ru.roman.certification.callorder;


import java.util.stream.Stream;

class CallOrderExmaple {

    public static void main(String[] args) {
        exec1();
        exec11();
        exec12();
        exec2();
        exec3();
        exec31();
        exec4();
    }

    private static void exec1() {
        int p1, p2, p3 = p2 = p1 = 0;
        try {
            foo().bazzy(p1 = one(), p2 = two(), p3 = three());
        } catch (NullPointerException e) {
            System.out.print(e + " ");
        } finally {
            System.out.print(">>> " + p1 + ", " + p2 + ", " + p3);
        }
        System.out.println();
    }

    private static void exec11() {
        int p1, p2, p3 = p2 = p1 = 0;
        try {
            fooThrow().bazzy(p1 = 1, p2 = 2, p3 = 3);
        } catch (NullPointerException e) {
            System.out.print(e + " ");
        } finally {
            System.out.print(">>> " + p1 + ", " + p2 + ", " + p3);
        }
        System.out.println();
    }

    private static void exec12() {
        int[] p1 = new int[1], p2 = new int[1], p3 = new int[1];
        Stream.iterate(0, (i) -> ++i).limit(1).peek((i) -> {
            try {
                //foo().bazzyStatic(p1 = 1, p2 = 2, p3 = 3);    // illegal
                //Barry.bazzyStatic(p1 = 1, p2 = 2, p3 = 3);

                foo().bazzyStatic(p1[0] = 1, p2[0] = 2, p3[0] = 3);


            } catch (NullPointerException e) {
                System.out.print(e + " ");
            } finally {
                System.out.print(">>> " + p1[0] + ", " + p2[0] + ", " + p3[0]);
            }
            System.out.println();
        }).count();
    }

    private static void exec2() {
        int p1, p2, p3 = p2 = p1 = 0;
        try {
            ++fooArr()[p1 = 1][p2 = 2][p3 = 3];
        } catch (NullPointerException e) {
            System.out.print(e + " ");
        } finally {
            System.out.print(">>> " + p1 + ", " + p2 + ", " + p3);
        }
        System.out.println();
    }

    private static void exec3() {
        int p1, p2, p3 = p2 = p1 = 0;
        try {
            ++fooArrArr()[p1 = 1][p2 = 2][p3 = 3];
        } catch (NullPointerException e) {
            System.out.print(e + " ");
        } finally {
            System.out.print(">>> " + p1 + ", " + p2 + ", " + p3);
        }
        System.out.println();
    }

    private static void exec31() {
        int p1, p2, p3 = p2 = p1 = 0;
        try {
            ++fooArrArr()[p1 = 111][p2 = 2][p3 = 3];
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            System.out.print(e + " ");
        } finally {
            System.out.print(">>> " + p1 + ", " + p2 + ", " + p3);
        }
        System.out.println();
    }

    private static void exec4() {
        int p1, p2, p3 = p2 = p1 = 0;
        try {
            ++throwSome()[p1 = 1][p2 = 2][p3 = 3];
        } catch (NullPointerException e) {
            System.out.print(e + " ");
        } finally {
            System.out.print(">>> " + p1 + ", " + p2 + ", " + p3);
        }
        System.out.println();
    }

    static Babary foo() {
        System.out.print("foo() ");
        return null;
    }

    static Barry fooThrow() {
        System.out.print("fooThrow() ");
        throw new NullPointerException();
    }

    static int[][][] fooArr() {
        System.out.print("fooArr() ");
        return null;
    }

    static int[][][] fooArrArr() {
        System.out.print("fooArrArr() ");
        return new int[99][][];
    }

    static int[][][] throwSome() {
        System.out.print("throwSome() ");
        throw new NullPointerException();
    }

    interface Barry {
        void bazzy(int i1, int i2, int i3);

        static void bazzyStatic(int p1, int p2, int p3) {
            System.out.print("Barry.bazzyStatic(" + p1 + ", " + p2 + ", " + p3 + ") ");
        }
    }

    static class Babary implements Barry {
        @Override
        public void bazzy(int p1, int p2, int p3) {
            System.out.print("bazzy(" + p1 + ", " + p2 + ", " + p3 + ") ");
        }

        static void bazzyStatic(int p1, int p2, int p3) {
            System.out.print("Babary.bazzyStatic(" + p1 + ", " + p2 + ", " + p3 + ") ");
        }
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