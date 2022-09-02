package pl.polsl.airlines.requests;

import lombok.Getter;

@Getter
public class PassengerCreateOrUpdateRequest {
  private String name;
  private String surname;
}
