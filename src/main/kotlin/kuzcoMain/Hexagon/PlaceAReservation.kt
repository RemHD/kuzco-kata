package kuzcoMain.Hexagon

import kuzcoMain.Hexagon.models.Reservation
import java.io.IOException
import java.util.*

open class PlaceAReservation(private val repository: RoomRepository) {
    fun execute(startDate: Date, endDate: Date, nbClient: Int, roomNumber: Int): Reservation {
        try {
            val result = Reservation(
                startDate = startDate,
                endDate = endDate,
                nbIencli = nbClient,
                roomNumber = roomNumber
            )
            repository.saveAReservation(result)
            return result
        } catch (error: IOException) {
            throw error
        }
    }
}