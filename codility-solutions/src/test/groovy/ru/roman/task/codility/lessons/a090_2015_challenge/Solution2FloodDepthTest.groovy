package ru.roman.task.codility.lessons.a090_2015_challenge

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2FloodDepthTest {
    //private Solution2FloodDepth subj = new Solution2FloodDepth()
    private Solution3FloodDepth subj = new Solution3FloodDepth()

    @DataProvider
    private Object[][] provider() {
        [
                [[1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2] as int[], 2],
                [[10, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2] as int[], 4],
                [[5, 8] as int[], 0],
                [[1] as int[], 0],
                [[1, 1] as int[], 0],
                [[2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2] as int[], 0],
                [[1, 5, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2] as int[], 4],
                [[989, 913, 951, 875, 77, 115, 39, 77, 1, 1, 77, 39, 875, 951, 913, 989] as int[], 988],
                [[989, 913, 951, 875, 913, 837, 875, 799, 837, 761, 799, 723, 761, 685, 723, 647, 685, 609, 647, 571, 609, 533, 571, 495, 533, 457, 495, 419, 457, 381, 419, 343, 381, 305, 343, 267, 305, 229, 267, 191, 229, 153, 191, 115, 153, 77, 115, 39, 77, 1, 1, 77, 39, 115, 77, 153, 115, 191, 153, 229, 191, 267, 229, 305, 267, 343, 305, 381, 343, 419, 381, 457, 419, 495, 457, 533, 495, 571, 533, 609, 571, 647, 609, 685, 647, 723, 685, 761, 723, 799, 761, 837, 799, 875, 837, 913, 875, 951, 913, 989] as int[], 988],

        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}