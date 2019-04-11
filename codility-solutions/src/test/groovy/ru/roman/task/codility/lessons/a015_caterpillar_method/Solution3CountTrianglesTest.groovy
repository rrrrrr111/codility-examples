package ru.roman.task.codility.lessons.a015_caterpillar_method

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution3CountTrianglesTest {
    private Solution3CountTriangles subj = new Solution3CountTriangles()

    @DataProvider
    private Object[][] provider() {
        [
                [[10, 2, 5, 1, 8, 12] as int[], 4],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}