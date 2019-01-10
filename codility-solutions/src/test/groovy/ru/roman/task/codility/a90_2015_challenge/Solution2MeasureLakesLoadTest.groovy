package ru.roman.task.codility.a90_2015_challenge

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2MeasureLakesLoadTest {
    private Solution2MeasureLakes subj = new Solution2MeasureLakes()

    @DataProvider
    private Object[][] provider() {
        final def size = 1_000_000
        final int[] list = new int[size]

        final def random = new Random()
        final int step = 1000

        int prev = 0
        int val = 0
        boolean turn = true

        final int max = 100_000_000
        for (int i = 0; i < list.length; i++) {
            if (turn) {
                val = val + step
            } else {
                val = val - step.intdiv(2)
            }

            list[i] = val
            prev = val
            turn = !turn
        }
        return [
                [list, 988],
        ] as Object[][]
    }

    @Test
    void test1() {


    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}