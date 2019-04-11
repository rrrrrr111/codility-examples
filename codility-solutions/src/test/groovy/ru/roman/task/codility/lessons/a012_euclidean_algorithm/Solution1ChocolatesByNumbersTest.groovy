package ru.roman.task.codility.lessons.a012_euclidean_algorithm

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1ChocolatesByNumbersTest {
    private Solution1ChocolatesByNumbers subj = new Solution1ChocolatesByNumbers()

    @DataProvider
    private Object[][] provider() {
        [
                [2, 1, 2],
                [1, 2, 1],
                [1, 1, 1],
                [10, 4, 5],
                [12, 21, 4],
                [123, 321, 41],
                [123000000, 789000000, 41],
                [268435456, 322486272, 16384],
                [1, 1_000_000_000, 1],
                [1_000_000_000, 1, 1_000_000_000],
                [1_000_000_000, 1_000_000_000, 1],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value1, int value2, int expected) {

        def actual = subj.solution(value1, value2)
        assert actual == expected
    }
}