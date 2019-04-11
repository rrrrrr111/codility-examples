package ru.roman.task.codility.lessons.a010_prime_and_composite

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution4FlagsTest {
    private Solution4Flags subj = new Solution4Flags()

    @DataProvider
    private Object[][] provider() {
        [
                [[1] as int[], 0],
                [[0, 1] as int[], 0],
                [[1, 0] as int[], 0],
                [[1, 0, 1] as int[], 0],
                [[0, 1, 0] as int[], 1],
                [[0, Integer.MAX_VALUE, 0] as int[], 1],
                [[0, 1, 0, 1, 0] as int[], 2],
                [[0, 1, 0, 1, 0, 1, 0] as int[], 2],
                [[0, 1, 0, 0, 1, 0, 0, 1, 0] as int[], 3],
                [[0, 1, 0, 0, 1, 0, 1, 0, 0] as int[], 2],
                [[0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0] as int[], 4],
                [[0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0] as int[], 4],
                [[0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0] as int[], 4],
                [[0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0] as int[], 9],

                [[1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2] as int[], 3],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}