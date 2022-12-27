package tech.arnav.parkinglot.parking

import tech.arnav.parkinglot.vehicle.Type

class Floor private constructor(
    val id: Int,
    val slots: List<Slot>,
    var emptySlots: Map<Type, Int>
) {
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
}