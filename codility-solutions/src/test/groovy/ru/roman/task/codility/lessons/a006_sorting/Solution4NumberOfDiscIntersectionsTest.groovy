package ru.roman.task.codility.lessons.a006_sorting

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution4NumberOfDiscIntersectionsTest {
    private Solution4NumberOfDiscIntersections subj = new Solution4NumberOfDiscIntersections()

    @DataProvider
    private Object[][] provider() {
        [
                [[1, 5, 2, 1, 4, 0] as int[], 11],
                [[3, 3, 3, 5, 1, 2] as int[], 15],
                [[1, 10, 100, 1] as int[], 5],
                [[1, 1, 1] as int[], 3],
                [[1, 0, 1, 0, 1] as int[], 6],
                [[1, 5, 8, 7, 8, 4, 8, 5, 0, 5] as int[], 41],
                [[12, 4, 20, 19, 9, 13, 4, 4, 6, 14, 4, 20, 1, 4, 1, 16, 7, 9, 6, 13] as int[], 176],
                [[7, 31, 8, 36, 30, 19, 31, 28, 2, 27, 31, 26, 44, 37, 19, 11, 6, 41, 35, 31, 22, 25, 11, 27, 7, 31, 32, 34, 12, 4, 16, 35, 26, 38, 21, 20, 46, 8, 10, 30, 32, 22, 28, 22, 34, 45, 42, 32, 23, 48] as int[], 1169],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}