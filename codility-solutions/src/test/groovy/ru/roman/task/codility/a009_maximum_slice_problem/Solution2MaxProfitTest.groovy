package ru.roman.task.codility.a009_maximum_slice_problem

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2MaxProfitTest {
    private Solution2MaxProfit subj = new Solution2MaxProfit()

    @DataProvider
    private Object[][] provider() {
        [
                [[1] as int[], 0],
                [[1, 2] as int[], 1],
                [[2, 1] as int[], 0],
                [[0, 200_000] as int[], 200_000],
                [[200_000, 0] as int[], 0],
                [[1, 3, 2, 5, 4, 7, 6, 9] as int[], 8],
                [[9, 6, 7, 4, 5, 2, 3, 1] as int[], 1],
                [[9, 7, 5, 7, 6, 5, 4, 3, 6, 5, 4, 1, 0] as int[], 3],
                [[23171, 21011, 21123, 21366, 21013, 21367] as int[], 356],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}