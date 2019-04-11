package ru.roman.task.codility.lessons.a099_future_training

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution3StrSymmetryPointTest {
    private Solution3StrSymmetryPoint subj = new Solution3StrSymmetryPoint()

    @DataProvider
    private Object[][] provider() {
        [
                ["x", 0],
                ["cx", -1],
                ["", -1],
                ["racecar", 3],
                ["racecarw", -1],
                ["wracecarw", 4],
                ["zwracecarwy", -1],
                ["ywratecarwy", -1],
                ["ywratetarwy", 5],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(String value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}