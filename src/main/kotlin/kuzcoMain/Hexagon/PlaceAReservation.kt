package kuzcoMain.Hexagon

import kuzcoMain.Hexagon.models.Reservation
import java.io.IOException
import java.util.*

open class PlaceAReservation(private val repository: RoomRepository) {
    fun execute(startDate: Date, endDate: Date, nbClient: Int, roomNumber: Int): Reservation? {
        try {
            val room = repository.getOne(roomNumber)
            return if (room == null) {
                null
            } else {
                val result = Reservation(
                    startDate = startDate,
                    endDate = endDate,
                    nbIencli = nbClient,
                    roomNumber = roomNumber
                )
                repository.saveAReservation(result)
                result
            }
        } catch (error: IOException) {
            throw error
        }
    }

    /*private fun checkRoomAvailability(roomNumber: Int, startDate: Date, endDate: Date): Boolean {

    }*/
}