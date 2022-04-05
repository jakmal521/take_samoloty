package pl.polsl.airlines.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PASSENGERS")
public class Passenger {
  /**
   * id of passenger
   */
  @Id
  @Column(name = "id")
  long id;

  /**
   *  passenger name
   */
  @Column(name = "name")
  String name;

  /**
   * passenger surname
   */
  @Column(name = "surname")
  String surname;
}
