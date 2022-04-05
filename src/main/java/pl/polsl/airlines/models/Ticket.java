/*
todo to be considered as a connection between flight and passenger
package pl.polsl.airlines.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TICKETS")
public class Ticket {
  */
/**
   * ticket id
   *//*

  @Id
  @Column(name = "id")
  private long id;

  */
/**
   * flight assigned to ticket
   *//*

  @Column(name = "flight_id")
  @ManyToOne
  private Flight flight;

  */
/**
   * passenger assigned to ticket
   *//*

  @ManyToOne
  private Passenger passenger;

  */
/**
   * seat number
   *//*

   private int number;
}
*/
