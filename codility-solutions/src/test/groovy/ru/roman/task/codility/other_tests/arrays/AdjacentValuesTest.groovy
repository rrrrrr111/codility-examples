package ru.roman.task.codility.other_tests.arrays

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class AdjacentValuesTest {
    private AdjacentValues subj = new AdjacentValues()

    @DataProvider
    private Object[][] provider() {
        [
                [[Integer.MAX_VALUE] as int[], -2],
                [[] as int[], -2],
                [[Integer.MAX_VALUE, Integer.MIN_VALUE] as int[], -1],
                [[0, 0] as int[], 0],
                [[1, 1] as int[], 0],
                [[10, -10] as int[], 20],
                [[0, 1_000_000_001] as int[], -1],
                [[0, 3, 3, 7, 5, 3, 11, 1] as int[], 0],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}