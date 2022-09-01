package pl.polsl.airlines.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Time;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "FLIGHTS", schema = "public")
public class Flight {

  /**
   * id of flight
   */
  @Id
  @GeneratedValue()
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
  @Column(name = "departure_time")
  private Time departureTime;

  /**
   * arrivalTime
   */
  @Column(name = "arrival_time")
  private Time arrivalTime;

  /**
   * departure airport
   */
  @ManyToOne
  @JoinColumn(name = "departureirport_id", referencedColumnName = "ID")
  private Airport departureAirport;

  /**
   * arrival airport
   */
  @ManyToOne
  @JoinColumn(name = "arrivalairport_id", referencedColumnName = "ID")
  private Airport arrivalAirport;

  /**
   * list of tickets
   */
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval=true)
  private List<Ticket> tickets;

  /**
   * plane
   */
  @ManyToOne
  private Plane plane;

  public Flight setDate(Date date) {
    this.date = date;
    return this;
  }

  public Flight setDepartureTime(Time departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  public Flight setArrivalTime(Time arrivalTime) {
    this.arrivalTime = arrivalTime;
    return this;
  }

  public Flight setDepartureAirport(Airport departureAirport) {
    this.departureAirport = departureAirport;
    return this;
  }

  public Flight setArrivalAirport(Airport arrivalAirport) {
    this.arrivalAirport = arrivalAirport;
    return this;
  }

  public Flight setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
    return this;
  }

  public Flight setPlane(Plane plane) {
    this.plane = plane;
    return this;
  }

  public boolean canBookTicket(){
    return tickets.size() < plane.getSeats();
  }
}
