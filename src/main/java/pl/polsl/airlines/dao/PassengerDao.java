package pl.polsl.airlines.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.polsl.airlines.models.Passenger;

import java.util.List;

public class PassengerDao extends ObjectDao {
  private Session session;
  private Transaction currentTransaction;

  public List<Passenger> getAll() {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    List<Passenger> passengers = session.createQuery("from Passenger ", Passenger.class).getResultList();
    currentTransaction.commit();
    session.close();
    return passengers;
  }


  public Passenger get(Long id) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    Passenger passenger = session.get(Passenger.class, id);
    currentTransaction.commit();
    session.close();
    return passenger;
  }

  public void create(Passenger passenger) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    session.persist(passenger);
    currentTransaction.commit();
    session.close();
  }

  public void update(Passenger passenger) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    session.update(passenger);
    currentTransaction.commit();
    session.close();
  }

  public void delete(Passenger passengerToDelete) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    session.delete(passengerToDelete);
    currentTransaction.commit();
    session.close();
  }

}
