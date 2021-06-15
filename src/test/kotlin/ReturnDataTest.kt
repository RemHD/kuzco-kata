import kuzcoMain.GetAllRoom
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class
ReturnDataTest {

    @Test
    fun getAllRoom() {
        // given
        val roomList = GetAllRoom()
        val expectedRoomList = arrayListOf<Room>()
        expectedRoomList.add(Room(1, 1, "1 king size bed - A/C - Wi-Fi - private bathroom", 1))

        // when
        val result = roomList.execute()
        // then
        assertEquals(result[0].etage, expectedRoomList[0].etage)
        assertEquals(result[0].chambre, expectedRoomList[0].chambre)
        assertEquals(result[0].description, expectedRoomList[0].description)
        assertEquals(result[0].capacite, expectedRoomList[0].capacite)
    }
}