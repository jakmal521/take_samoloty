package pl.polsl.airlines.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
  List<Ticket> tickets;

  public Passenger setId(long id) {
    this.id = id;
    return this;
  }

  public Passenger setName(String name) {
    this.name = name;
    return this;
  }

  public Passenger setSurname(String surname) {
    this.surname = surname;
    return this;
  }
}
