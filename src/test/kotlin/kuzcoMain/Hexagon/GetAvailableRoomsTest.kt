package kuzcoMain.Hexagon

import kuzcoMain.Hexagon.models.Reservation
import kuzcoMain.Hexagon.models.Room
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import java.util.*

class GetAvailableRoomsTest {

    @Test
    fun getRooms() {
        //given
        val roomRepository = Mockito.mock(RoomRepository::class.java)
        val getRooms = GetAvailableRooms(roomRepository)
        val expectedRoomList = arrayListOf(
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
            ), Room(
                etage = 1,
                chambre = 2,
                description = "1 king size bed - A/C - Wi-Fi - private bathroom",
                capacite = "2 guest",
                Reservation = arrayListOf(
                    Reservation(
                        startDate = Date(2021, 9, 1),
                        endDate = Date(2021, 9, 15),
                        nbIencli = 2,
                        roomNumber = 102
                    )
                )
            )
        )
        given(getRooms.execute(Date(2021, 6, 1), Date(2021, 9, 28), 2)).willReturn(expectedRoomList)

        //when
        val result = getRooms.execute(Date(2021, 6, 1), Date(2021, 9, 28), 2)


        //then
        assertThat(result).isEqualTo(expectedRoomList)
    }
}