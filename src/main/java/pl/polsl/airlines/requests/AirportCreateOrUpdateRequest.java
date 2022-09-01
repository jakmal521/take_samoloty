package pl.polsl.airlines.requests;

import lombok.Getter;

@Getter
public class AirportCreateOrUpdateRequest {
  private String airportName;
  private String city;
}
