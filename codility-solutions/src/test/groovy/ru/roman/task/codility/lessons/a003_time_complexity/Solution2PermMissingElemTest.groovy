package ru.roman.task.codility.lessons.a003_time_complexity

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2PermMissingElemTest {
    private Solution2PermMissingElem subj = new Solution2PermMissingElem()

    @DataProvider
    private Object[][] provider() {
        [
                [[2, 3, 1, 5] as int[], 4],
                [[2, 3, 4, 5] as int[], 1],
                [[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14] as int[], 11],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}