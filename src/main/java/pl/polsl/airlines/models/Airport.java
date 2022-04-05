package pl.polsl.airlines.models;

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

  /**
   * id of airport
   */
  @Id
  @GeneratedValue
  @Column(name = "id")
  private long id;

  /**
   * name of airport
   */
  @Column(name = "airportName")
  private String airportName;

  /**
   * city where airport is placed
   */
  @Column(name = "city")
  private String city;
}
