package tech.arnav.parkinglot.parking

class Lot(
    val id: Int,
    val floors: List<Floor>
) {
    fun getFloor(id: Int) = floors.find { it.id == id }

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
}

