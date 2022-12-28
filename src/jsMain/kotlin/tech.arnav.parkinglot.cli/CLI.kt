package tech.arnav.parkinglot.cli

import node_modules.ReadlineSync

actual fun prompt(message: String): String {
    return ReadlineSync.question("$message: ")
}