package ru.roman.kotlin.certification.nonNull


fun main(args: Array<String>) {

    val nullable: List<Any>? = null

    println(nullable?.size)

    val values: Map<Any, Any> = HashMap()
    values["email"] ?: throw IllegalStateException("missing!")
}
