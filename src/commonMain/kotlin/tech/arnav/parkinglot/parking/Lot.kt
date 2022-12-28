package tech.arnav.parkinglot.parking

import tech.arnav.parkinglot.vehicle.Vehicle

class Lot(
    val id: Int,
    val floors: List<Floor>
): ParkHandler {
    private val parkingIds: MutableMap<Vehicle, String> = mutableMapOf()
    fun getFloor(id: Int) = floors.find { it.id == id }
    fun findVehicle(registrationNumber: String): Vehicle {
        return parkingIds.keys.find {
            it.registrationNumber == registrationNumber
        } ?: throw IllegalStateException("Vehicle $registrationNumber not found in this lot")
    }

    /**
     * Lot Builder
     */
    data class Builder(
        private var id: Int = 0,
    ) {
        private var floors: List<Floor> = emptyList()

        fun addFloor(floor: Floor) = apply { floors += floor }
        fun build() = Lot(id, floors)
    }

    @Throws(IllegalStateException::class)
    override fun park(vehicle: Vehicle): String {
        val floor = floors.find {
            val emptySlotsOfType = it.emptySlots.get(vehicle.type)
            return@find  (emptySlotsOfType != null && emptySlotsOfType > 0)
        } ?: throw IllegalStateException("No floor with empty slots of type ${vehicle.type} found")

        val parkedFloorSlotId = floor.park(vehicle)
        val parkingId = "$id-$parkedFloorSlotId"
        parkingIds[vehicle] = "$id-$parkedFloorSlotId"
        return parkingId
    }

    @Throws(IllegalStateException::class)
    override fun unpark(vehicle: Vehicle): Boolean {
        val parkingId = parkingIds[vehicle]
            ?: throw IllegalStateException("Vehicle with registration number ${vehicle.registrationNumber} not found")
        val (lotId, floorId, slotId) = parkingId.split("-")
        val floor = getFloor(floorId.toInt()) ?: throw IllegalStateException("Floor with id $floorId not found")
        floor.unpark(vehicle)
        parkingIds.remove(vehicle)
        return true
    }
}

