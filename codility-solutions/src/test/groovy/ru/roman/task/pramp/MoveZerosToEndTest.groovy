package ru.roman.task.pramp

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class MoveZerosToEndTest {
    private MoveZerosToEnd subj = new MoveZerosToEnd()

    @DataProvider
    private Object[][] provider() {
        [
                [[] as int[], [] as int[]],
                [[1] as int[], [1] as int[]],
                [[0] as int[], [0] as int[]],
                [[0, 0] as int[], [0, 0] as int[]],
                [[1, 0] as int[], [1, 0] as int[]],
                [[0, 1] as int[], [1, 0] as int[]],
                [[0, 0, 1] as int[], [1, 0, 0] as int[]],
                [[1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0] as int[], [1, 10, 2, 8, 3, 6, 4, 5, 7, 0, 0, 0, 0, 0] as int[]],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int[] expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}