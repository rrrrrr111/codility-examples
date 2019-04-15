package ru.roman.task.codility.other_tests.geometry;

/**
 * The girl moves on points, she went from point (AX, AY) to point (BX, BY) turned right 90 degrees and goes straight, you need to determine the first point she will meet
 */
class GirlLivingOnCage {
    public String solution(int AX, int AY, int BX, int BY) {
        System.out.printf("On input: %s %s %s %s%n", AX, AY, BX, BY);

        if (AX == BX && AY == BY)
            throw new IllegalArgumentException();

        // if parallel to one of axes
        if (AX == BX)
            if (AY < BY) return String.format("%d,%d", BX + 1, BY);
            else return String.format("%d,%d", BX - 1, BY);
        else if (AY == BY)
            if (AX < BX) return String.format("%d,%d", BX, BY - 1);
            else return String.format("%d,%d", BX, BY + 1);

        // otherwise
        int xDistance = (AX > 0) == (BX > 0) ? Math.abs(AX - BX) : Math.abs(AX) + Math.abs(BX);
        int yDistance = (AY > 0) == (BY > 0) ? Math.abs(AY - BY) : Math.abs(AY) + Math.abs(BY);
        int gcd = gcd(xDistance, yDistance);
        xDistance /= gcd;
        yDistance /= gcd;


        if (AX < BX && AY < BY) return String.format("%d,%d", BX + yDistance, BY - xDistance);
        if (AX < BX && BY < AY) return String.format("%d,%d", BX - yDistance, BY - xDistance);
        if (BX < AX && AY < BY) return String.format("%d,%d", BX + yDistance, BY + xDistance);
        if (BX < AX && BY < AY) return String.format("%d,%d", BX - yDistance, BY + xDistance);

        throw new IllegalStateException();
    }

    private static int gcd(int a, int b) {
        int res = 1;

        for (; ; ) {
            if (a == b) {
                return res * a;
            } else if ((a % 2 == 0) && (b % 2 == 0)) {
                a /= 2;
                b /= 2;
                res *= 2;
            } else if (a % 2 == 0) {
                a /= 2;
            } else if (b % 2 == 0) {
                b /= 2;

            } else if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
    }
}
