package tech.arnav.parkinglot.vehicle

data class Vehicle(
    val registrationNumber: String,
    val color: Color,
    val type: Type,
    val brand: String,
    val model: String
)