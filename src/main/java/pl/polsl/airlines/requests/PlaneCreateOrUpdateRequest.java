package pl.polsl.airlines.requests;

import lombok.Getter;

@Getter
public class PlaneCreateOrUpdateRequest {
  String model;
  int seats;
}
