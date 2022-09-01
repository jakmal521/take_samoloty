package pl.polsl.airlines.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.polsl.airlines.models.Airport;

import java.util.List;
import java.util.Optional;

public class AirportDao extends ObjectDao{

  private Session session;
  private Transaction currentTransaction;
  
  public Optional<List<Airport>> getAll() {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    List<Airport> planes = session.createQuery("from Airport ", Airport.class).getResultList();
    currentTransaction.commit();
    session.close();
    return Optional.of(planes);
  }

  public Airport get(Long id) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    Airport airport = session.get(Airport.class, id);
    currentTransaction.commit();
    session.close();
    return airport;
  }

  public void create(Airport airport) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    session.merge(airport);
    currentTransaction.commit();
    session.close();
  }

  public void update(Airport airport) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    session.update(airport);
    currentTransaction.commit();
    session.close();
  }

  public void delete(Airport airport) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    session.delete(airport);
    currentTransaction.commit();
    session.close();
  }

}
