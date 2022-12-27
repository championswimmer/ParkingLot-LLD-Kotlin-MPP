package tech.arnav.parkinglot.parking

import tech.arnav.parkinglot.vehicle.Type
import kotlin.test.Test
import kotlin.test.assertEquals

class FloorTests {

    @Test
    fun can_build_floor() {
        val floor = Floor.Builder()
            .id(1)
            .addSlots(Type.CAR, 10)
            .addSlots(Type.MOTORBIKE, 5)
            .build()

        assertEquals(1, floor.id)
        assertEquals(15, floor.slots.size)
    }
}