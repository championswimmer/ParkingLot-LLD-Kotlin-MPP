package tech.arnav.parkinglot.parking

import tech.arnav.parkinglot.vehicle.Type

data class Slot(
    val id: Int,
    val type: Type
)