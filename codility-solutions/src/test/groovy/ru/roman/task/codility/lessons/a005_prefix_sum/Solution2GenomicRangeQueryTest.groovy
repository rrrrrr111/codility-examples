package ru.roman.task.codility.lessons.a005_prefix_sum

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2GenomicRangeQueryTest {
    private Solution2GenomicRangeQuery subj = new Solution2GenomicRangeQuery()

    @DataProvider
    private Object[][] provider() {
        [
                ["A", [0] as int[], [0] as int[], [1] as int[]],
                ["C", [0] as int[], [0] as int[], [2] as int[]],
                ["G", [0] as int[], [0] as int[], [3] as int[]],
                ["T", [0] as int[], [0] as int[], [4] as int[]],
                ["AAAAAAAAAAAA", [0, 2, 4] as int[], [0, 2, 8] as int[], [1, 1, 1] as int[]],
                ["CC", [0, 0] as int[], [0, 1] as int[], [2, 2] as int[]],
                ["GGGGGGGGGGGGGGGGGGGG", [0] as int[], [18] as int[], [3] as int[]],
                ["TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT", [0, 0] as int[], [0, 33] as int[], [4, 4] as int[]],
                ["CAGCCTA", [2, 5, 0] as int[], [4, 5, 6] as int[], [2, 4, 1] as int[]],
                ["AC", [0, 0, 1] as int[], [0, 1, 1] as int[], [1, 1, 2] as int[]],
                ["GTT", [0, 1] as int[], [2, 2] as int[], [3, 4] as int[]],
                ["TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTGTTTTTTTTTTTTTTTTTTTTTTTTTTTTTCTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT ",
                    [0, 5, 33, 35, 10] as int[], [31, 32, 50, 70, 75] as int[], [4, 3, 4, 2, 2] as int[]],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(String value1, int[] value2, int[] value3, int[] expected) {

        def actual = subj.solution(value1, value2, value3)
        assert actual == expected
    }
}