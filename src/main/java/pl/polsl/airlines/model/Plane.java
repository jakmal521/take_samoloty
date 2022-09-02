package pl.polsl.airlines.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PLANE")
public class Plane {

  public Plane(String model, int seats) {
    this.model = model;
    this.seats = seats;
  }
  public Plane(){

  }

  /**
   * id of plane
   */
  @Id
  @GeneratedValue
  long id;

  /**
   * producer and name of plane
   */
  String model;

  /**
   * number of available seats in plane
   */
  int seats;
}
