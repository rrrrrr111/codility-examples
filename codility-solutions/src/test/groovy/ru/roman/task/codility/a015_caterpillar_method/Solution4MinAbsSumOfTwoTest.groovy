package ru.roman.task.codility.a015_caterpillar_method

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import static java.lang.Integer.MAX_VALUE
import static java.lang.Integer.MIN_VALUE

@CompileStatic
@Test
class Solution4MinAbsSumOfTwoTest {
    private Solution4MinAbsSumOfTwo subj = new Solution4MinAbsSumOfTwo()

    @DataProvider
    private Object[][] provider() {
        [
                [[0] as int[], 0],
                [[1] as int[], 2],
                [[-1] as int[], 2],
                [[MIN_VALUE + 3, -3] as int[], 6],
                [[MIN_VALUE + 3, 0] as int[], 0],
                [[MAX_VALUE - 3, 3] as int[], 6],
                [[MAX_VALUE - 3, 3, 0] as int[], 0],
                [[MAX_VALUE - 3, MIN_VALUE + 4] as int[], 0],
                [[MAX_VALUE - 3, MIN_VALUE + 3] as int[], 1],
                [[1, 4, -3] as int[], 1],
                [[-8, 4, 5, -10, 3] as int[], 3],
                [[MAX_VALUE - 3, MIN_VALUE + 3, 0] as int[], 0],
                [[-1000000000, -999999999] as int[], 1999999998],
                [[8, 5, 3, 4, 6, 8] as int[], 6],
                [[-8, -5, -4, -10, -12, -18] as int[], 8],
                [[-3, 123, 345, 678, -345, 456, -680, -211, 0] as int[], 0],
                [[-3, 123, 345, 2, 678, -34, 456, -680, 1, -211] as int[], 1],
                [[-3, 123, 345, -2, 678, -34, 456, -680, 1, -211] as int[], 1],
                [[-3, 123, 345, 2, 678, -34, 456, -680, -1, -211] as int[], 1],
                [[-30, -29, -28, -26, -25, 3, 4, 5, 6, 7, 8, 9, 10] as int[], 7],
                [[-30, -29, -28, -26, -25, 3, 4, 5, 6, 7, 8, 9, 10, 0] as int[], 0],
                [[30, 29, 28, 26, 25, -3, -4, -5, -6, -7, -8, -9, -10] as int[], 7],
                [[30, 29, 28, 26, 25, -3, -4, -5, -6, -7, -8, -9, -10, 0] as int[], 0],
                [[-30, -28, -26, -24, -22, -20, 18, -17, 19, 21, 23, 25, 27, 29] as int[], 1],
                [[-30, -28, -26, -24, -22, -20, 0, 18, 17, 19, 21, 23, 25, 27, 29] as int[], 0],
                [[30, 28, 26, 24, 22, 20, 18, -17, -19, -21, -23, -25, -27, -29] as int[], 1],
                [[30, 28, 26, 24, 22, 20, 18, -17, 0, -19, -21, -23, -25, -27, -29] as int[], 0],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}