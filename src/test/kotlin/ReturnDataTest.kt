import org.junit.Test
import kotlin.test.assertEquals

class ReturnDataTest {
    @Test
    fun getAllRoom() {
        // given
        val expectedRoomList = arrayListOf<Room>()
        expectedRoomList.add(Room(1, 1, "1 king size bed - A/C - Wi-Fi - private bathroom", 1))

        // when
        GetAllRoom.execute()
        // then
        assertEquals(GetAllRoom.getAllRoom(), expectedRoomList)
    }
}