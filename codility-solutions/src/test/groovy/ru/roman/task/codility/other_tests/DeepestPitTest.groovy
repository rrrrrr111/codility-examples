package ru.roman.task.codility.other_tests

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class DeepestPitTest {
    private DeepestPit subj = new DeepestPit()

    @DataProvider
    private Object[][] provider() {
        [
                [[0, 0, 0] as int[], 0],
                [[-1, 0, 0] as int[], -1],
                [[-10, -1, 0] as int[], -1],
                [[1, 0, 1] as int[], 1],
                [[0, -1, 0] as int[], 1],
                [[100000000, -100000000, 100000000] as int[], 200000000],
                [[49, -1, 100000000] as int[], 50],
                [[0, 1, 3, -2, 0, 1, 0, -3, 2, 3] as int[], 4],
                [[1, 3, 5, 7, 9, 11, 350, 116, -118, 123, 238, 353, 468, 583, 698, 813, 928, 1043] as int[], 468],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}