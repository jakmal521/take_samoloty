package pl.polsl.airlines.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FlightTest {
  private final Flight flight = new Flight();
  private final Plane PLANE = mock(Plane.class);
  private final int NUMBER_OF_PLANE_SEATS = 50;

  @ParameterizedTest
  @MethodSource("dataForTicketsTest")
  void canBuyTicketTest(int numberOfBookedTickets, boolean expectedResult){
    flight.setPassengers(new ArrayList<>(numberOfBookedTickets));
    assertThat(flight.canBookTicket()).isEqualTo(expectedResult);
  }

  Stream<Arguments> dataForTicketsTest(){
    return Stream.of(
            Arguments.of(0, true),
            Arguments.of(30, true),
            Arguments.of(49, true),
            Arguments.of(50, false),
            Arguments.of(51, false),
            Arguments.of(100, false)
    );
  }

  @BeforeEach
  void setUp(){
    flight.setPlane(PLANE);
    when(PLANE.getNumberOfSeats()).thenReturn(NUMBER_OF_PLANE_SEATS);
  }
}