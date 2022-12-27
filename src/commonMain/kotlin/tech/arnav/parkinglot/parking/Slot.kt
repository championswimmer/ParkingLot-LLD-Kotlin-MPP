package tech.arnav.parkinglot.parking

import tech.arnav.parkinglot.vehicle.Type
import tech.arnav.parkinglot.vehicle.Vehicle

data class Slot(
    val id: Int,
    val type: Type,
    var vehicle: Vehicle? = null
)