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
                [[0] as int[], [0] as int[], 0],
                [[0, 0] as int[], [0, 0] as int[], 1],
                [[0, 0, 0, 0] as int[], [0, 0, 2, 2] as int[], 2],
                [[0, 0, 0, 0, 0, 0, 0, 0] as int[], [0, 0, 0, 0, 2, 2, 2, 2] as int[], 12],
                [[1, 3] as int[], [400_000, 500_000] as int[], 1],
                [[1, 6] as int[], [172915, 783185] as int[], 0],
                [[1, 60] as int[], [16803, 513157] as int[], 0],
                [[1, 1, 1, 2, 2, 3, 5, 6] as int[], [200000, 250000, 500000, 0, 0, 0, 0, 0] as int[], 16],
                [[0, 1, 2, 2, 3, 5] as int[], [500_000, 500_000, 0, 0, 0, 20_000] as int[], 8],
                [[3, 4, 5] as int[], [0, 0, 0] as int[], 3],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value1, int[] value2, int expected) {

        def actual = subj.solution(value1, value2)
        assert actual == expected
    }
}