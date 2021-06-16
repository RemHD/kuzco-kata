package kuzcoMain.Hexagon

import kuzcoMain.Hexagon.models.Reservation
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.Mockito
import java.util.*

class PlaceAReservationTest {
    @Test
    fun placeAReservation() {
        //given
        val roomRepository = Mockito.mock(RoomRepository::class.java)
        val reservationPlacer = PlaceAReservation(roomRepository)
        val expectedReservation = Reservation(
            startDate = Date(),
            endDate = Date(),
            nbIencli = 2,
            roomNumber = 102
        )

        //when
        val result = reservationPlacer.execute(startDate = Date(),
            endDate = Date(),
            nbClient = 2,
            roomNumber = 102
        )

        //then
        then(roomRepository).should().saveAReservation(expectedReservation)
        assertThat(result).isEqualTo(expectedReservation)

    }

    @Test
    fun `placeAReservation when room does not exist then should not place a reservation`() {
        // given
        val roomRepository = Mockito.mock(RoomRepository::class.java)
        val reservationPlacer = PlaceAReservation(roomRepository)

        // when
        val result = reservationPlacer.execute(startDate = Date(),
            endDate = Date(),
            nbClient = 2,
            roomNumber = 999
        )

        // then
        then(roomRepository).should().getOne(999)
        then(roomRepository).shouldHaveNoMoreInteractions()
        assertThat(result).isEqualTo(null)
    }
}