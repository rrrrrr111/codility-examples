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
                [0, 0],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}