package pl.polsl.airlines.requests;

import lombok.Getter;

@Getter
public class FlightCreateOrUpdateRequest {
  private String date;
  private String departureTime;
  private String arrivalTime;
  private long departureAirport;
  private long arrivalAirport;
  private long plane;
}
