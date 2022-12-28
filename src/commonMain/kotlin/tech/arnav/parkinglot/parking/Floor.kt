package tech.arnav.parkinglot.parking

import tech.arnav.parkinglot.vehicle.Type
import tech.arnav.parkinglot.vehicle.Vehicle

class Floor private constructor(
    val id: Int,
    val slots: List<Slot>,
    var emptySlots: Map<Type, Int>
): ParkHandler {
    fun updateEmptySlots() {
        emptySlots = slots.groupBy { it.type }.mapValues {
            it.value.count { slot -> slot.vehicle == null }
        }
    }

    fun getSlot(id: Int) = slots.find { it.id == id }

    /**
     * Floor Builder
     */
    data class Builder(
        private var id: Int = 0,
        private var slots: List<Slot> = emptyList()
    ) {
        fun id(id: Int) = apply { this.id = id }
        fun addSlots(type: Type, count: Int) = apply {
            for (i in slots.size until slots.size + count) {
                slots += Slot(i, type)
            }
        }

        fun build() = Floor(id, slots, slots.groupBy { it.type }.mapValues { it.value.size })
    }

    override fun park(vehicle: Vehicle): String {
        val emptySlot = slots.find { it.vehicle == null && it.type == vehicle.type }
            ?: throw IllegalStateException("No empty slots available")
        val parkedSlotId = emptySlot.park(vehicle)
        updateEmptySlots()
        return "$id-$parkedSlotId"
    }

    override fun unpark(vehicle: Vehicle): Boolean {
        val slot = slots.find { it.vehicle == vehicle }
            ?: throw IllegalStateException("Vehicle with registration number ${vehicle.registrationNumber} not found")
        slot.unpark(vehicle)
        updateEmptySlots()
        return true
    }
}