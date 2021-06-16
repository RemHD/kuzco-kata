package kuzcoMain.Hexagon

import kuzcoMain.Hexagon.models.Reservation
import kuzcoMain.Hexagon.models.Room
import java.io.IOException
import java.util.*

open class PlaceAReservation(private val repository: RoomRepository) {
    fun execute(startDate: Date, endDate: Date, nbClient: Int, roomNumber: Int): Reservation? {
        try {
            val room = repository.getOne(roomNumber)
            return if (room == null) {
                null
            } else {
                if (checkRoomAvailability(room, startDate, endDate)) {
                    val result = Reservation(
                        startDate = startDate,
                        endDate = endDate,
                        nbIencli = nbClient,
                        roomNumber = roomNumber
                    )
                    repository.saveAReservation(result)
                    result
                } else {
                    null
                }

            }
        } catch (error: IOException) {
            throw error
        }
    }

    private fun checkRoomAvailability(room: Room, startDate: Date, endDate: Date): Boolean =
        room.Reservation.fold(true) { acc: Boolean, reservation: Reservation ->
            if (
                (startDate >= reservation.endDate && endDate > reservation.endDate) ||
                (startDate < reservation.startDate && endDate <= reservation.startDate)
            ) acc else false
        }
}