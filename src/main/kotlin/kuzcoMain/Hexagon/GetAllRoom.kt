package kuzcoMain.Hexagon

import kuzcoMain.Hexagon.models.Room

open class GetAllRoom(val roomRepository: RoomRepository) {

    fun execute(): ArrayList<Room> {
        return roomRepository.getAll()
    }
}
