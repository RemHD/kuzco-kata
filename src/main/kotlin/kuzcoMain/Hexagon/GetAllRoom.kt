package kuzcoMain.Hexagon

open class GetAllRoom(val roomRepository: RoomRepository) {

    fun execute(): ArrayList<Room> {
        return roomRepository.getAll()
    }
}
