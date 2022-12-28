package tech.arnav.parkinglot.cli

import tech.arnav.parkinglot.parking.Floor
import tech.arnav.parkinglot.parking.Lot

object StatusPrinter {
    fun printLotStatus(lot: Lot) {
        println(
            """
                |${"-".repeat(30)}
                |Lot ${lot.id} Status:
                """.trimMargin()
        )
        lot.floors.forEach { floor ->
            printFloorStatus(floor)
        }
    }

    fun printFloorStatus(floor: Floor) {
        println(
            """
                |${"-".repeat(15)}
                |Floor ${floor.id} Status:
                |Type       Empty
                """.trimMargin()
        )
        floor.emptySlots.forEach { (type, count) ->
            println(
                """
                    |$type       $count
                    """.trimMargin()
            )
        }
    }
}

