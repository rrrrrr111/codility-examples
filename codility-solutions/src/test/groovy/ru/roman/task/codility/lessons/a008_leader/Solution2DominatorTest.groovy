package ru.roman.task.codility.lessons.a008_leader

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2DominatorTest {
    private Solution2Dominator subj = new Solution2Dominator()

    @DataProvider
    private Object[][] provider() {
        [
                [[] as int[], -1],
                [[0] as int[], 0],
                [[0, 1] as int[], -1],
                [[0, 1, 1] as int[], 2],
                [[0, 1, 3] as int[], -1],
                [[0, 1, 1, 1] as int[], 3],
                [[3, 4, 3, 2, 3, -1, 3, 3] as int[], 7],
                [[3, 4, 3, 2, 3, -1, 3, 3, 1] as int[], 7],
                [[3, 3, 3, 2, 3, -1, 3, 3, 1, Integer.MAX_VALUE, Integer.MIN_VALUE] as int[], 7],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}