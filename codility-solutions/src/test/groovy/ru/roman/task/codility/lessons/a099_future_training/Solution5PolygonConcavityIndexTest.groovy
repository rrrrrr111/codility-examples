package ru.roman.task.codility.lessons.a099_future_training

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution5PolygonConcavityIndexTest {
    private Solution5PolygonConcavityIndex subj = new Solution5PolygonConcavityIndex()

    @DataProvider
    private Object[][] provider() {
        [
                [[] as int[], 0],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}