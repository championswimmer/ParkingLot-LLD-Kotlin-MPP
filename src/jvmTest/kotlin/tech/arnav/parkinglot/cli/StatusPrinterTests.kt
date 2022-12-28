package tech.arnav.parkinglot.cli

import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import tech.arnav.parkinglot.parking.Floor
import tech.arnav.parkinglot.parking.Lot
import tech.arnav.parkinglot.vehicle.Color
import tech.arnav.parkinglot.vehicle.Type
import tech.arnav.parkinglot.vehicle.Vehicle
import kotlin.test.Test
import kotlin.test.assertEquals

class StatusPrinterTests {
    private fun createLot() = Lot.Builder()
        .addFloor(
            Floor.Builder()
                .id(0)
                .addSlots(Type.CAR, 10)
                .addSlots(Type.BIKE, 5)
                .build()
        )
        .addFloor(
            Floor.Builder()
                .id(1)
                .addSlots(Type.CAR, 10)
                .addSlots(Type.BIKE, 5)
                .build()
        )
        .build()


    @Test
    fun testPrintLotStatus() {
        val lot = createLot()
        with(tapSystemOut {
            StatusPrinter.printLotStatus(lot)
        }) {
            assertEquals(
                """
                |------------------------------
                |Lot 0 Status:
                |---------------
                |Floor 0 Status:
                |Type       Empty
                |CAR       10
                |BIKE       5
                |---------------
                |Floor 1 Status:
                |Type       Empty
                |CAR       10
                |BIKE       5

                """.trimMargin(),
                this
            )
        }
    }

    @Test
    fun testPrintLotStatusAfterParking() {
        val lot = createLot()
        val parkedSlot = lot.park(Vehicle("KA-01-HH-1234", Color.RED, Type.CAR, "Hyundai", "i20"))
        assertEquals("0-0-0", parkedSlot)
        with(tapSystemOut {
            StatusPrinter.printLotStatus(lot)
        }) {
            assertEquals(
                """
                |------------------------------
                |Lot 0 Status:
                |---------------
                |Floor 0 Status:
                |Type       Empty
                |CAR       9
                |BIKE       5
                |---------------
                |Floor 1 Status:
                |Type       Empty
                |CAR       10
                |BIKE       5

                """.trimMargin(),
                this
            )
        }
    }
}