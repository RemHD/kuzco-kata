package kuzcoMain.Hexagon

import kuzcoMain.Hexagon.models.Reservation
import kuzcoMain.Hexagon.models.Room

interface RoomRepository {
    fun getAll(): ArrayList<Room>
    fun saveAReservation(reservation: Reservation)
}