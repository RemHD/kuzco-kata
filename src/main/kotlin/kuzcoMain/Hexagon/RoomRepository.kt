package kuzcoMain.Hexagon

import kuzcoMain.Hexagon.models.Reservation
import kuzcoMain.Hexagon.models.Room
import java.util.*
import kotlin.collections.ArrayList

interface RoomRepository {
    fun getAll(): ArrayList<Room>
    fun saveAReservation(reservation: Reservation)
    fun getOne(roomNumber: Number): Room?
    fun getWithinDate(startDate: Date, endDate: Date): ArrayList<Room>
}