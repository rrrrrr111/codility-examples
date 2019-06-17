package ru.roman.kotlin.certification.inputstream

import java.nio.file.Files
import java.nio.file.Paths

fun main() {

    Files.newInputStream(Paths.get("/some/file.txt"))
            .buffered()                                   // wrap with BufferedInputStream
            .reader()                                     // wrap with InputStreamReader
            .use {                                        // try-with-resource analog
                reader ->  println(reader.readText())
            }
}