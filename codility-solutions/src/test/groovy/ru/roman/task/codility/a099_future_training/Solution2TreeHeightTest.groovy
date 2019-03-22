package ru.roman.task.codility.a099_future_training

import groovy.transform.CompileStatic
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

@CompileStatic
@Test
class Solution2TreeHeightTest {
    private Solution2TreeHeight subj = new Solution2TreeHeight()

    @DataProvider
    private Object[][] provider() {
        [
                [new Tree(5,
                        new Tree(3,
                                new Tree(20),
                                new Tree(21)
                        ),
                        new Tree(10,
                                new Tree(1),
                                null
                        )
                ), 2],
                [new Tree(15,
                        new Tree(18,
                                new Tree(20,
                                        new Tree(22,
                                                new Tree(24,
                                                        new Tree(26,
                                                                new Tree(28),
                                                                null
                                                        ),
                                                        null
                                                ),
                                                null
                                        ),
                                        null
                                ),
                                null
                        ),
                        new Tree(11,
                                null,
                                new Tree(9,
                                        null,
                                        new Tree(7,
                                                null,
                                                new Tree(5,
                                                        null,
                                                        new Tree(3,
                                                                null,
                                                                new Tree(1,
                                                                        null,
                                                                        new Tree(1,
                                                                                null,
                                                                                new Tree(-1)
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                ), 8],
                [null, 0],
                [new Tree(0), 0],
        ] as Object[][]
    }

    @Test(dataProvider = "provider")
    void test(Tree value, int expected) {

        def actual = subj.solution(value)
        assert actual == expected
    }
}