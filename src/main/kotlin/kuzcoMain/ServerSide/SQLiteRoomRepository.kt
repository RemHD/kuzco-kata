package kuzcoMain.ServerSide

import kuzcoMain.Hexagon.models.Room
import kuzcoMain.Hexagon.RoomRepository
import kuzcoMain.Hexagon.models.Reservation

class SQLiteRoomRepository: RoomRepository {

    override fun getAll(): ArrayList<Room> {
        TODO("Not yet implemented")
    }

    override fun saveAReservation(reservation: Reservation) {
        TODO("Not yet implemented")
    }

    override fun getOne(roomNumber: Number): Room? {
        TODO("Not yet implemented")
    }
}