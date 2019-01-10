package ru.roman.task.codility.a03_time_complexity

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2FindAbsentTest {
    private Solution2FindAbsent subj = new Solution2FindAbsent()

    @DataProvider
    private Object[][] provider() {
        [
                [[2,3,1,5] as int[], 4],
                [[2,3,4,5] as int[], 1],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}