package ru.roman.task.codility.other_tests

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class CountMultiplicativePairsTest {
    private CountMultiplicativePairs subj = new CountMultiplicativePairs()

    @DataProvider
    private Object[][] provider() {
        [
                [[0, 1, 2, 2, 3, 5] as int[], [500000, 500000, 0, 0, 0, 2000] as int[], 8],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int[] value2, int expected) {

        def actual = subj.solution(value1, value2)
        assert actual == expected
    }
}