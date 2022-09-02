package pl.polsl.airlines.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "AIRPORTS")
public class Airport {
  public Airport() {
  }

  /**
   * id of airport
   */
  @Id
  @GeneratedValue
  private long id;

  /**
   * name of airport
   */
  @Column(name = "airport_name", unique = true)
  private String airportName;

  /**
   * city where airport is placed
   */
  private String city;

  public Airport setId(long id) {
    this.id = id;
    return this;
  }

  public Airport setAirportName(String airportName) {
    this.airportName = airportName;
    return this;
  }

  public Airport setCity(String city) {
    this.city = city;
    return this;
  }
}
