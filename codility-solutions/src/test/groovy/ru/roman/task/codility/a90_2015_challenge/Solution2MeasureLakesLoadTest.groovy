package ru.roman.task.codility.a90_2015_challenge

import groovy.transform.CompileStatic
import org.testng.annotations.BeforeClass
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2MeasureLakesLoadTest {
    private final Solution2MeasureLakes subj = new Solution2MeasureLakes()

    static int[] list

    @BeforeClass
    static void setUp() {
        final int size = 100_000
        final int half = size.intdiv(2).intValue()
        list = new int[size]

        final int max = 100_000_000
        final int step = 1_000

        int val = max
        boolean turn = true


        for (int i = 0; i < list.length; i++) {
            if (i >= half) {
                if (turn) {
                    val = val + step
                } else {
                    val = val - step.intdiv(2)
                }
            } else {
                if (turn) {
                    val = val - step
                } else {
                    val = val + step.intdiv(2)
                }
            }
            list[i] = val
            turn = !turn
        }
    }

    @DataProvider
    private Object[][] provider() {
        [
                [list, 12500000],
        ] as Object[][]
    }

    @Test(dataProvider = "provider", timeOut = 3_000L)
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}