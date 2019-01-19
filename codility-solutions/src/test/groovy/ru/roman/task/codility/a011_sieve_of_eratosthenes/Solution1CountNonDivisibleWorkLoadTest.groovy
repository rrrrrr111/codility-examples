package ru.roman.task.codility.a011_sieve_of_eratosthenes

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import java.util.stream.IntStream

@CompileStatic
@Test
class Solution1CountNonDivisibleWorkLoadTest {
    private Solution1CountNonDivisibleWithSieve subj = new Solution1CountNonDivisibleWithSieve()

    @DataProvider
    private Object[][] provider() {
        int size = 100_000
        [
                [IntStream.range(0, size).map({ 83160 }).toArray()],
                [new Random().ints(size, 1, 100_000).toArray()],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(int[] value) {

        int[] res = subj.solution(value)

        println("Result has ${res.length} elements")
    }
}