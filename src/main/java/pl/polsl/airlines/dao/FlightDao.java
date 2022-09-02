package pl.polsl.airlines.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.polsl.airlines.model.Flight;

import java.util.List;

public class FlightDao extends ObjectDao {

  private Session session;
  private Transaction currentTransaction;


  public List<Flight> getAll() {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    List<Flight> flights = session.createQuery("from Flight", Flight.class).getResultList();
    currentTransaction.commit();
    session.close();
    return flights;
  }


  public Flight get(Long id) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    Flight flight = session.get(Flight.class, id);
    currentTransaction.commit();
    session.close();
    return flight;
  }

  public void delete(Flight flightToDelete) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    session.delete(flightToDelete);
    currentTransaction.commit();
    session.close();
  }

  public void update(Flight flight) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    session.update(flight);
    currentTransaction.commit();
    session.close();
  }

  public void create(Flight flight) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    session.persist(flight);
    currentTransaction.commit();
    session.close();
  }
}
