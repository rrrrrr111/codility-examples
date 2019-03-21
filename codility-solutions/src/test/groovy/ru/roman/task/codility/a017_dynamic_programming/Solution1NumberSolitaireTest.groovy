package ru.roman.task.codility.a017_dynamic_programming

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution1NumberSolitaireTest {
    private Solution1NumberSolitaire subj = new Solution1NumberSolitaire()

    @DataProvider
    private Object[][] provider() {
        [
                [[0, -1, -2, -3, -4, -5, -6, -41, -13, -112, -11, -555, 10, 0, 0, 0, 46, 0, 0] as int[], 50],
                [[1, -2, 0, 9, -1, -2] as int[], 8],
                [[-10, -10] as int[], -20],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}