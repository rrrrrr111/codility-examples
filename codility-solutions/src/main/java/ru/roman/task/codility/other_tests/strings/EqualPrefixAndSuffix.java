package ru.roman.task.codility.other_tests.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * <div class="task-description-content task-description__TaskContentWrapper-sc-380ibo-1 iVZZWO">
 * <p>
 * <meta http-equiv="content-type" content="text/html; charset=utf-8">
 *
 *
 * <div id="brinza-task-description">
 * <p>A <i>prefix</i> of a string S is any leading contiguous part of S. For example, the string "<tt style="white-space:pre-wrap">codility</tt>" has the following prefixes: "<tt style="white-space:pre-wrap"></tt>", "<tt style="white-space:pre-wrap">c</tt>", "<tt style="white-space:pre-wrap">co</tt>", "<tt style="white-space:pre-wrap">cod</tt>", "<tt style="white-space:pre-wrap">codi</tt>", "<tt style="white-space:pre-wrap">codil</tt>", "<tt style="white-space:pre-wrap">codili</tt>", "<tt style="white-space:pre-wrap">codilit</tt>" and "<tt style="white-space:pre-wrap">codility</tt>". A prefix of S is called <i>proper</i> if it is shorter than S.</p>
 * <p>A <i>suffix</i> of a string S is any trailing contigous part of S. For example, the string "<tt style="white-space:pre-wrap">codility</tt>" has the following suffixes: "<tt style="white-space:pre-wrap"></tt>", "<tt style="white-space:pre-wrap">y</tt>", "<tt style="white-space:pre-wrap">ty</tt>", "<tt style="white-space:pre-wrap">ity</tt>", "<tt style="white-space:pre-wrap">lity</tt>", "<tt style="white-space:pre-wrap">ility</tt>", "<tt style="white-space:pre-wrap">dility</tt>", "<tt style="white-space:pre-wrap">odility</tt>" and "<tt style="white-space:pre-wrap">codility</tt>". A suffix of S is called <i>proper</i> if it is shorter than S.</p>
 * <p>Write a function:</p>
 * <blockquote><p style="font-family: monospace; font-size: 9pt; display: block; white-space: pre-wrap"><tt>class Solution { public int solution(String S); }</tt></p></blockquote>
 * <p>that, given a string S consisting of N characters, returns the length of the longest string that is both a proper prefix of S and a proper suffix of S.</p>
 * <p>For example, given S = "<tt style="white-space:pre-wrap">abbabba</tt>" the function should return 4, because:</p>
 * <blockquote><ul style="margin: 10px;padding: 0px;"><li>proper prefixes of S are: "<tt style="white-space:pre-wrap"></tt>", "<tt style="white-space:pre-wrap">a</tt>", "<tt style="white-space:pre-wrap">ab</tt>", "<tt style="white-space:pre-wrap">abb</tt>", "<tt style="white-space:pre-wrap">abba</tt>", "<tt style="white-space:pre-wrap">abbab</tt>", "<tt style="white-space:pre-wrap">abbabb</tt>";</li>
 * <li>proper suffixes of S are: "<tt style="white-space:pre-wrap"></tt>", "<tt style="white-space:pre-wrap">a</tt>", "<tt style="white-space:pre-wrap">ba</tt>", "<tt style="white-space:pre-wrap">bba</tt>", "<tt style="white-space:pre-wrap">abba</tt>", "<tt style="white-space:pre-wrap">babba</tt>", "<tt style="white-space:pre-wrap">bbabba</tt>";</li>
 * <li>string "<tt style="white-space:pre-wrap">abba</tt>" is both a proper prefix and a proper suffix of S;</li>
 * <li>this is the longest such string.</li>
 * </ul>
 * </blockquote><p>For example, given S = "<tt style="white-space:pre-wrap">codility</tt>" the function should return 0, because:</p>
 * <blockquote><ul style="margin: 10px;padding: 0px;"><li>string "<tt style="white-space:pre-wrap"></tt>" is both a proper prefix and a proper suffix of S;</li>
 * <li>this is the longest such string.</li>
 * </ul>
 * </blockquote><p>Write an <b><b>efficient</b></b> algorithm for the following assumptions:</p>
 * <blockquote><ul style="margin: 10px;padding: 0px;"><li>the length of S is within the range [<span class="number">1</span>..<span class="number">1,000,000</span>];</li>
 * <li>string S consists only of lowercase letters (<tt style="white-space:pre-wrap">a</tt>−<tt style="white-space:pre-wrap">z</tt>).</li>
 * </ul>
 * </blockquote></div>
 * <div style="margin-top:5px">
 * </div>
 *
 * </div>
 */
class EqualPrefixAndSuffix {
    public int solution(String S) {
        System.out.printf("On input: %s%n", S);

        char[] chars = S.toCharArray();
        if (chars.length < 2) {
            return 0;
        }

        Set<String> suffs = new HashSet<>(1_000_000);
        for (int i = chars.length - 1; i > 0; i--) {
            suffs.add(S.substring(i, chars.length));
        }

        for (int i = chars.length - 1; i > 0; i--) {

            if (suffs.contains(S.substring(0, i))) {
                return i;
            }
        }
        return 0;
    }
}
