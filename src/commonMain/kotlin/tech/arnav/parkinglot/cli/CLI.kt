package tech.arnav.parkinglot.cli

expect fun prompt(message: String): String

internal fun _commonPrompt(message: String): String {
    println("$message: ")
    return readln()
}
