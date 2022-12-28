package tech.arnav.parkinglot

import tech.arnav.parkinglot.cli.CLIItemFactory
import tech.arnav.parkinglot.cli.StatusPrinter
import tech.arnav.parkinglot.cli.prompt

class App {
    fun start() {
        println("Parking Lot Program Started")

        val parkingLot = CLIItemFactory.createLot()
        StatusPrinter.printLotStatus(parkingLot)

        val vehicle = CLIItemFactory.createVehicle()
        println(vehicle)

    }
}