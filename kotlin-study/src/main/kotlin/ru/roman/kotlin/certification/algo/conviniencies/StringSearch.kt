package ru.roman.kotlin.certification.algo.conviniencies

fun main() {

    // indexOf
    "str".indexOfFirst { it > 'a' }

}

/** Prepare LSP for KMP (Knuth Morris Pratt) Algorithm */
fun prepareLsp(pattern: String): IntArray {
    val lsp = IntArray(pattern.length) { 0 }
    var lspIdx = 1                    // start from 1, 0-index cell allways 0
    var patIdx = 0
    var len = 0                       // lengh of the match so far
    while (lspIdx <= lsp.lastIndex) {
        if (pattern[patIdx] == pattern[lspIdx]) {
            lsp[lspIdx++] = ++len     // set match length and move forward
            patIdx++
        } else if (len == 0) {
            lspIdx++                  // just move forward, leave default value of 0 in lps
        } else {
            len = lsp[patIdx - 1]     // tricky, we backtracking using lps collected so far
            patIdx = lsp[patIdx - 1]  // to check for matching
        }
    }
    println(">>>>>>>>>V1>> Word: ${pattern.toCharArray().contentToString()}")
    println(">>>>>>>>>V1>> LSP: ${lsp.contentToString()}")
    return lsp
}

/** Prepare LPS for KMP (Knuth Morris Pratt) Algorithm (Variant 2) */
fun prepareLspV2(pattern: String): IntArray {
    val lsp = IntArray(pattern.length)
    lsp[0] = 0 // Base case

    for (i in 1 until pattern.length) {
        // Start by assuming we're extending the previous LSP
        var j = lsp[i - 1]
        while (j > 0 && pattern[i] != pattern[j]) j = lsp[j - 1]
        if (pattern[i] == pattern[j]) j++
        lsp[i] = j
    }
    println(">>>>>>>>>V2>> Word: ${pattern.toCharArray().contentToString()}")
    println(">>>>>>>>>V2>> LSP: ${lsp.contentToString()}")
    return lsp
}