package pl.polsl.airlines.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PLANES")
public class Plane {
  /**
   * id of plane
   */
  @Id
  @Column(name = "id")
  long id;

  /**
   * producer and name of plane
   */
  @Column(name = "model")
  String model;

  /**
   * number of available seats in plane
   */
  @Column(name = "seats")
  int numberOfSeats;
}
