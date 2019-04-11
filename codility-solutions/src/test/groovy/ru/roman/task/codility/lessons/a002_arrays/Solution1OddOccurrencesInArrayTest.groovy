package ru.roman.task.codility.lessons.a002_arrays

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1OddOccurrencesInArrayTest {
    private Solution1OddOccurrencesInArray subj = new Solution1OddOccurrencesInArray()

    @DataProvider
    private Object[][] provider() {
        [
                [[1, 3, 1] as int[], 3],
                [[1, 1, 1, 0, 1] as int[], 0],
                [[91, 69, 77, 91, 26, 64, 91, 88, 58, 17, 42, 100, 11, 32, 96, 45, 21, 32, 91, 34, 43, 63, 81, 50, 9, 58, 4, 10, 20, 70, 29, 70, 17, 12, 3, 71, 86, 22, 24, 2, 65, 31, 14, 65, 60, 45, 16, 64, 56, 44, 17, 93, 87, 69, 100, 59, 35, 12, 61, 52, 44, 100, 84, 12, 89, 1, 66, 32, 73, 96, 54, 77, 6, 67, 12, 46, 34, 8, 75, 10, 26, 9, 67, 31, 5, 3, 22, 51, 2, 3, 67, 53, 14, 32, 13, 28, 39, 22, 20, 23, 42, 91, 69, 77, 91, 26, 64, 91, 88, 58, 17, 42, 100, 11, 32, 96, 45, 21, 32, 91, 34, 43, 63, 81, 50, 9, 58, 4, 10, 20, 70, 29, 70, 17, 12, 3, 71, 86, 22, 24, 2, 65, 31, 14, 65, 60, 45, 16, 64, 56, 44, 17, 93, 87, 69, 100, 59, 35, 12, 61, 52, 44, 100, 84, 12, 89, 1, 66, 32, 73, 96, 54, 77, 6, 67, 12, 46, 34, 8, 75, 10, 26, 9, 67, 31, 5, 3, 22, 51, 2, 3, 67, 53, 14, 32, 13, 28, 39, 22, 20, 23] as int[], 42],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}