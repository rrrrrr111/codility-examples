package ru.roman.task.codility.a010_prime_and_composite

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution3PeaksTest {
    private Solution3Peaks subj = new Solution3Peaks()

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