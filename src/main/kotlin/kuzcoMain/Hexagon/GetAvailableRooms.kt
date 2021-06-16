package kuzcoMain.Hexagon

import kuzcoMain.Hexagon.models.Room
import java.util.*

open class GetAvailableRooms(val repository: RoomRepository) {
    fun execute(startDate: Date, endDate: Date, nbTraveler: Int): ArrayList<Room> {
        return repository.getWithinDate(startDate, endDate)
    }
}