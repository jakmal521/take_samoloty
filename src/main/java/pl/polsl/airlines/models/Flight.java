package pl.polsl.airlines.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "FLIGHTS")
public class Flight {

  /**
   * id of flight
   */
  @Id
  @GeneratedValue
  @Column(name = "id")
  private long id;

  /**
   * date of flight
   */
  @Column(name = "date")
  private Date date;

  /**
   * departure time
   */
  @Column(name = "departureTime")
  private Time departureTime;

  /**
   * arrivalTime
   */
  @Column(name = "arrivalTime")
  private Time arrivalTime;

  /**
   * departure airport
   */
  @ManyToOne
  private Airport departureAirport;

  /**
   * arrival airport
   */
  @ManyToOne
  private Airport arrivalAirport;

  /**
   * list of tickets
   */
  @OneToMany
  private List<Ticket> tickets;

  /**
   * plane
   */
  @ManyToOne
  private Plane plane;

  boolean canBookTicket(){
    return tickets.size() < plane.getNumberOfSeats();
  }
}
