import kuzcoMain.Hexagon.GetAllRoom
import kuzcoMain.Hexagon.Room
import kuzcoMain.Hexagon.RoomRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock

class GetAllRoomTest {

    @Test
    fun getAllRoom() {
        // given
        val roomRepository = mock(RoomRepository::class.java)
        val getAllRoom = GetAllRoom(roomRepository)
        val expectedRoomList = arrayListOf<Room>()
        expectedRoomList.add(Room(1, 1, "1 king size bed - A/C - Wi-Fi - private bathroom", 1))
        given(getAllRoom.execute()).willReturn(expectedRoomList)

        // when
        val result = getAllRoom.execute()
        // then
        assertThat(result).isEqualTo(expectedRoomList)
    }
}