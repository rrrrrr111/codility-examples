package ru.roman.task.codility.a03_time_complexity

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1FrogImpTest {
    private Solution1FrogImp subj = new Solution1FrogImp()

    @DataProvider
    private Object[][] provider() {
        [
                [0, 0, 0, 0],
                [1, 2, 1, 1],
                [0, 2, 1, 2],
                [10, 20, 3, 4],
                [10, 85, 30, 3],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value1, int value2, int value3, int expected) {

        def actual = subj.solution(value1, value2, value3)
        assert actual == expected
    }
}