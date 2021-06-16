package kuzcoMain.Hexagon.models

import java.util.Date

data class Reservation(
    val startDate: Date,
    val endDate: Date,
    val nbIencli: Int,
    val roomNumber: Int
)
