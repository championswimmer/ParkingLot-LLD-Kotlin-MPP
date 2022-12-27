package tech.arnav.parkinglot

import tech.arnav.parkinglot.cli.LotCLIUtils
import tech.arnav.parkinglot.parking.Floor
import tech.arnav.parkinglot.parking.Lot
import tech.arnav.parkinglot.vehicle.Type

class App {
    fun start() {
        println("Parking Lot Program Started")

        val lot = Lot.Builder()
            .addFloor(
                Floor.Builder()
                    .id(1)
                    .addSlots(Type.CAR, 10)
                    .addSlots(Type.BIKE, 5)
                    .build()
            )
            .addFloor(
                Floor.Builder()
                    .id(2)
                    .addSlots(Type.CAR, 10)
                    .addSlots(Type.BIKE, 5)
                    .build()
            )
            .build()
        LotCLIUtils.printLotStatus(lot)
    }
}