package tech.arnav.parkinglot.parking

import tech.arnav.parkinglot.vehicle.Vehicle

interface ParkHandler {
    /**
     * parks a vehicle
     * @return the slot+floor+lot number where it was parked
     * @throws [IllegalStateException] if the vehicle cannot be parked
     */
    @Throws(IllegalStateException::class)
    fun park(vehicle: Vehicle): String

    /**
     * unparks a vehicle
     * @return true if the vehicle was found and unparked
     * @throws [IllegalStateException] if the vehicle cannot be found
     */
    @Throws(IllegalStateException::class)
    fun unpark(vehicle: Vehicle): Boolean
}