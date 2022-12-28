package tech.arnav.parkinglot.parking

import tech.arnav.parkinglot.vehicle.Type
import tech.arnav.parkinglot.vehicle.Vehicle

data class Slot(
    val id: Int,
    val type: Type,
    var vehicle: Vehicle? = null
) : ParkHandler {
    @Throws(IllegalStateException::class)
    override fun park(vehicle: Vehicle): String {
        if (this.vehicle != null) {
            throw IllegalStateException("Slot is already occupied")
        }
        this.vehicle = vehicle
        return this.id.toString()
    }

    @Throws(IllegalStateException::class)
    override fun unpark(vehicle: Vehicle): Boolean {
        if (this.vehicle != vehicle) {
            throw IllegalStateException("Wrong vehicle parked in this slot")
        }
        this.vehicle = null
        return true
    }
}