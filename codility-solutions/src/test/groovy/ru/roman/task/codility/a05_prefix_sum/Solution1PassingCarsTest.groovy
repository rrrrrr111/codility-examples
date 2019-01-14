package ru.roman.task.codility.a05_prefix_sum

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1PassingCarsTest {
    private Solution1PassingCars subj = new Solution1PassingCars()

    @DataProvider
    private Object[][] provider() {
        [
                [[0] as int[], 0],
                [[1] as int[], 0],
                [[0, 0, 0, 0, 0] as int[], 0],
                [[0, 0, 1, 1, 1, 1, 0] as int[], 8],
                [[0, 1] as int[], 1],
                [[0, 1, 1, 1, 1, 1, 1, 0] as int[], 6],
                [[1, 1, 1, 1, 0, 1, 0] as int[], 1],
                [[1, 1, 1, 1, 0, 1, 1, 0, 1] as int[], 4],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}