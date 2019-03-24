package ru.roman.task.codility.a099_future_training

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution4ArrayInversionCountTest {
    private Solution4ArrayInversionCount subj = new Solution4ArrayInversionCount()

    @DataProvider
    private Object[][] provider() {
        [
                [[1, 2, 4, 3, 5, 6] as int[], 1],
                [[1, 5, 4, 3, 2, 6] as int[], 6],
                [[6, 5, 4, 3, 2, 1] as int[], 15],
                [[-1, 6, 3, 4, 7, 4] as int[], 4],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}