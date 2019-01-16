package ru.roman.task.codility.a004_counting

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1PermCheckTest {
    private Solution1PermCheck subj = new Solution1PermCheck()

    @DataProvider
    private Object[][] provider() {
        [
                [[4, 1, 3, 2] as int[], 1],
                [[4, 6, 5, 7] as int[], 0],
                [[4, 1, 3] as int[], 0],
                [[1, 1, 1, 1, 1, 1, 1] as int[], 0],
                [[1_000_000_000, 1_000_000_000, 1_000_000_000] as int[], 0],
                [[1_000_000_000] as int[], 0],
                [[1_000_000_000, 999_999_999] as int[], 0],
                [[1] as int[], 1],
                [[1, 1_000_000_000] as int[], 0],
                [[2, 1] as int[], 1],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}