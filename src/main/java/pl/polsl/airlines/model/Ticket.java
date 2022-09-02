
package pl.polsl.airlines.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TICKETS")
public class Ticket {
  /**
   * ticket id
   */

  @Id
  @Column(name = "id")
  private long id;

  /**
   * seat number
   */

  private int number;

  public Ticket setId(long id) {
    this.id = id;
    return this;
  }

  public Ticket setNumber(int number) {
    this.number = number;
    return this;
  }
}


