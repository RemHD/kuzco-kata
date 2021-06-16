import kuzcoMain.Hexagon.GetAllRoom
import kuzcoMain.Hexagon.models.Room
import kuzcoMain.Hexagon.RoomRepository
import kuzcoMain.Hexagon.models.Reservation
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock
import java.util.*

class GetAllRoomTest {

    @Test
    fun getAllRoom() {
        // given
        val roomRepository = mock(RoomRepository::class.java)
        val getAllRoom = GetAllRoom(roomRepository)
        val expectedRoomList = arrayListOf<Room>()
        expectedRoomList.add(
            Room(
                etage = 1,
                chambre = 1,
                description = "1 king size bed - A/C - Wi-Fi - private bathroom",
                capacite = "1 guest",
                Reservation = arrayListOf(
                    Reservation(
                        startDate = Date(2021, 6, 1),
                        endDate = Date(2021, 6, 15),
                        nbIencli = 2,
                        roomNumber = 102
                    )
                )
            )
        )
        given(getAllRoom.execute()).willReturn(expectedRoomList)

        // when
        val result = getAllRoom.execute()
        // then
        assertThat(result).isEqualTo(expectedRoomList)
    }
}