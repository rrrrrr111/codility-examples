package ru.roman.task.codility.a011_sieve_of_eratosthenes

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import java.util.stream.IntStream

@CompileStatic
@Test
class Solution1CountNonDivisibleWorkLoadTest {
    private Solution1CountNonDivisible subj = new Solution1CountNonDivisible()

    @DataProvider
    private Object[][] provider() {
        int size = 1_000_000
        [
                [IntStream.range(0, size).map({ 83160 }).toArray(), IntStream.range(0, size).map({ 0 }).toArray()],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value, int[] expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}