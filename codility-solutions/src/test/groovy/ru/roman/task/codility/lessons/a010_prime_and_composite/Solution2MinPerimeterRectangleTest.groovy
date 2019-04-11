package ru.roman.task.codility.lessons.a010_prime_and_composite

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2MinPerimeterRectangleTest {
    private Solution2MinPerimeterRectangle subj = new Solution2MinPerimeterRectangle()

    @DataProvider
    private Object[][] provider() {
        [
                [1, 4],
                [2, 6],
                [3, 8],
                [4, 8],
                [10, 14],
                [16, 16],
                [30, 22],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}