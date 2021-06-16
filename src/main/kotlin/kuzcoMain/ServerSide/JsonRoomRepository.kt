package kuzcoMain.ServerSide

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kuzcoMain.Hexagon.models.Room
import kuzcoMain.Hexagon.RoomRepository
import kuzcoMain.Hexagon.models.Reservation
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class JsonRoomRepository : RoomRepository {
    override fun getAll(): ArrayList<Room> {
        val gson = Gson()
        val rawJsonFile = File("./src/main/resources/json/rooms.json").readText(Charsets.UTF_8)
        val listRoomDefinition = object : TypeToken<List<Room>>() {}.type
        return gson.fromJson(rawJsonFile, listRoomDefinition)
    }

    override fun saveAReservation(reservation: Reservation) {
        TODO("Not yet implemented")
    }

    override fun getOne(roomNumber: Number): Room? {
        TODO("Not yet implemented")
    }

    override fun getWithinDate(startDate: Date, endDate: Date): ArrayList<Room> {
        TODO("Not yet implemented")
    }


}