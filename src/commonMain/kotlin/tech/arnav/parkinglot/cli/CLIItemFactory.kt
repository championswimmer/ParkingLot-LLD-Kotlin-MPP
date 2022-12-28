package tech.arnav.parkinglot.cli

import tech.arnav.parkinglot.parking.Floor
import tech.arnav.parkinglot.parking.Lot
import tech.arnav.parkinglot.vehicle.Color
import tech.arnav.parkinglot.vehicle.Type
import tech.arnav.parkinglot.vehicle.Vehicle


class CLIItemFactory {
    companion object {
        /**
         * Interactively creates a [Lot] with CLI inputs
         */
        fun createLot(): Lot {
            val lotBuilder = Lot.Builder()
            val floors = prompt("How many floors are there in the parking lot?")
                .toIntOrNull()
                ?: throw IllegalArgumentException("Invalid number of floors")

            for (floor in 0 until floors) {
                lotBuilder.addFloor(createFloor(floor))
            }
            return lotBuilder.build()
        }

        /**
         * Interactively creates a [Floor] with CLI inputs
         */
        fun createFloor(floorId: Int): Floor {
            val floorBuilder = Floor.Builder()
            Type.values().forEach { type ->
                val slots = prompt("How many ${type.name} slots are there on floor $floorId?")
                    .toIntOrNull()
                    ?: throw IllegalArgumentException("Invalid number of slots")
                floorBuilder.addSlots(type, slots)
            }
            return floorBuilder.build()
        }

        /**
         * Interactively creates a [Vehicle] with CLI inputs
         */
        fun createVehicle(): Vehicle {
            val type = prompt("What type of vehicle is it? " + Type.values().joinToString(" | ") { it.name })
                .takeIf { it.isNotEmpty() }?.let { Type.valueOf(it.trim()) }
                ?: throw IllegalArgumentException("Invalid vehicle type")
            val registrationNumber = prompt("What is the registration number of the vehicle?")
                ?: throw IllegalArgumentException("Invalid registration number")
            val color = prompt("What is the color of the vehicle? " + Color.values().joinToString(" | ") { it.name })
                .takeIf { it.isNotEmpty() }?.let { Color.valueOf(it) }
                ?: throw IllegalArgumentException("Invalid color")
            val brand = prompt("What is the brand of the vehicle?")
                .takeIf { it.isNotEmpty() } ?: throw IllegalArgumentException("Brand cannot be empty")
            val model = prompt("What is the model of the vehicle?")
                .takeIf { it.isNotEmpty() } ?: throw IllegalArgumentException("Model cannot be empty")

            return Vehicle(registrationNumber, color, type, brand, model)
        }
    }
}
