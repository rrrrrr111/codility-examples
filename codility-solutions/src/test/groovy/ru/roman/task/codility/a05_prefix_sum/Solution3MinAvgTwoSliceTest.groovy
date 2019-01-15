package ru.roman.task.codility.a05_prefix_sum

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution3MinAvgTwoSliceTest {
    private Solution3MinAvgTwoSlice subj = new Solution3MinAvgTwoSlice()

    @DataProvider
    private Object[][] provider() {
        [
                [[4, 2, 2, 5, 1, 5, 8] as int[], 1],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}