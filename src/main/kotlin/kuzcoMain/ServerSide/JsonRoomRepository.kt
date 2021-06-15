package kuzcoMain.ServerSide

import kuzcoMain.Hexagon.Room
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kuzcoMain.Hexagon.RoomRepository
import java.io.File

class JsonRoomRepository : RoomRepository {
    override fun getAll(): ArrayList<Room> {
        val gson = Gson()
        val rawJsonFile = File("./src/main/resources/json/rooms.json").readText(Charsets.UTF_8)
        val listRoomDefinition = object : TypeToken<List<Room>>() {}.type
        return gson.fromJson(rawJsonFile, listRoomDefinition)
    }
}