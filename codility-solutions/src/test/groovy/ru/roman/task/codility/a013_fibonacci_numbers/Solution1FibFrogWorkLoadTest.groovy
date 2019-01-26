package ru.roman.task.codility.a013_fibonacci_numbers

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import java.util.stream.IntStream

@CompileStatic
@Test
class Solution1FibFrogWorkLoadTest {
    //private Solution1FibFrog subj = new Solution1FibFrog()
    //private Solution2FibFrog subj = new Solution2FibFrog()
    private Solution3FibFrog subj = new Solution3FibFrog()

    @DataProvider
    private Object[][] provider() {
        [
                [IntStream.range(0, 100_000).map({ 1 }).toArray(), 6],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}