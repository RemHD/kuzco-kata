package kuzcoMain

import Room
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

open class GetAllRoom {

    fun execute(): ArrayList<Room> {
        val gson = Gson()
        val rawJsonFile = File("./src/main/resources/json/rooms.json").readText(Charsets.UTF_8)
        val listRoomDefinition = object : TypeToken<List<Room>>() {}.type
        return gson.fromJson(rawJsonFile, listRoomDefinition)
    }
}
