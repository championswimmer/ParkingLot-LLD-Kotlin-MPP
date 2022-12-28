package tech.arnav.parkinglot.cli

import tech.arnav.parkinglot.parking.Lot

class CLIParkingLotManager(
    val lot: Lot
) {

    fun start() {
        when (prompt(
            """
            Pick an opertation: (enter the number) 
            1. Park a vehicle
            2. Unpark a vehicle
            3. Get status of the parking lot
        """.trimIndent()
        )) {
            "1" -> park()
            "2" -> unpark()
            "3" -> status()
            else -> {
                println("Invalid operation")
                start()
            }
        }
    }

    private fun park() {
        val vehicle = CLIItemFactory.createVehicle()
        try {
            val parkingId = lot.park(vehicle)
            println("MESSAGE: Vehicle parked successfully with at $parkingId")
        } catch (e: IllegalStateException) {
            println("ERROR: Did not park car")
        } finally {
            start()
        }

    }

    private fun unpark() {
        val regNum = prompt("Enter the registration number of the vehicle to unpark")
        try {
            val vehicle = lot.findVehicle(regNum)
            println("MESSAGE: Vehicle found")
            println(vehicle)
            val confirm = prompt("Confirm unpark? Y/N (default: N)")
            if (confirm == "Y" || confirm == "y") {
                lot.unpark(vehicle)
                println("MESSAGE: Vehicle unparked successfully")
            }
        } catch (e: IllegalStateException) {
            println("ERROR: Did not unpark car")
        } finally {
            start()
        }
    }

    private fun status() {
        StatusPrinter.printLotStatus(lot)
        start()
    }
}