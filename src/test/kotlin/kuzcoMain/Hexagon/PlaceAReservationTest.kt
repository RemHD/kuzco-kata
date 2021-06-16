package kuzcoMain.Hexagon

import kuzcoMain.Hexagon.models.Reservation
import kuzcoMain.Hexagon.models.Room
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
            startDate = Date(2021, 8, 1),
            endDate = Date(2021, 8, 15),
            nbIencli = 2,
            roomNumber = 102
        )
        given(roomRepository.getOne(102)).willReturn(
            Room(
                etage = 1,
                chambre = 102,
                description = "blabla",
                capacite = "1",
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

        //when
        val result = reservationPlacer.execute(
            startDate = Date(2021, 8, 1),
            endDate = Date(2021, 8, 15),
            nbClient = 2,
            roomNumber = 102
        )

        //then
        then(roomRepository).should().getOne(102)
        then(roomRepository).should().saveAReservation(expectedReservation)
        assertThat(result).isEqualTo(expectedReservation)
    }

    @Test
    fun `placeAReservation - when room does not exist - then should do nothing`() {
        // given
        val roomRepository = Mockito.mock(RoomRepository::class.java)
        val reservationPlacer = PlaceAReservation(roomRepository)

        // when
        val result = reservationPlacer.execute(
            startDate = Date(),
            endDate = Date(),
            nbClient = 2,
            roomNumber = 999
        )

        // then
        then(roomRepository).should().getOne(999)
        then(roomRepository).shouldHaveNoMoreInteractions()
        assertThat(result).isEqualTo(null)
    }


    @Test
    fun `placeAReservation - when room does exist and Startdate is between existing Reservation's dates - then should do nothing`() {
        // given
        val roomRepository = Mockito.mock(RoomRepository::class.java)
        val reservationPlacer = PlaceAReservation(roomRepository)
        given(roomRepository.getOne(102)).willReturn(
            Room(
                etage = 1,
                chambre = 102,
                description = "blabla",
                capacite = "1",
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

        // when
        val result = reservationPlacer.execute(
            startDate = Date(2021, 6, 12),
            endDate = Date(2021, 6, 27),
            nbClient = 2,
            roomNumber = 102
        )

        // then
        then(roomRepository).should().getOne(102)
        then(roomRepository).shouldHaveNoMoreInteractions()
        assertThat(result).isEqualTo(null)
    }

    @Test
    fun `placeAReservation - when room does exist and EndDate is between existing Reservation's dates - then should do nothing`() {
        // given
        val roomRepository = Mockito.mock(RoomRepository::class.java)
        val reservationPlacer = PlaceAReservation(roomRepository)
        given(roomRepository.getOne(102)).willReturn(
            Room(
                etage = 1,
                chambre = 102,
                description = "blabla",
                capacite = "1",
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

        // when
        val result = reservationPlacer.execute(
            startDate = Date(2021, 5, 25),
            endDate = Date(2021, 6, 8),
            nbClient = 2,
            roomNumber = 102
        )

        // then
        then(roomRepository).should().getOne(102)
        then(roomRepository).shouldHaveNoMoreInteractions()
        assertThat(result).isEqualTo(null)
    }
}