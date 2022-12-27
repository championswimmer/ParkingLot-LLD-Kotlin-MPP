package tech.arnav.parkinglot.cli

import tech.arnav.parkinglot.parking.Lot

class LotCLIUtils {
    companion object {
        fun printLotStatus(lot: Lot) {
            println(
                """
                |Lot ${lot.id} Status:
                |Floor        Type       Empty
                |${"-".repeat(30)}
                """.trimMargin()
            )
            lot.floors.forEach { floor ->
                floor.emptySlots.forEach { (type, count) ->
                    println(
                    """
                    |${floor.id}             $type       $count
                    """.trimMargin()
                    )
                }
            }
        }
    }
}