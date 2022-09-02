package pl.polsl.airlines.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import pl.polsl.airlines.model.Plane;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneDao extends ObjectDao {

  private Session session;
  private Transaction currentTransaction;

  public Optional<List<Plane>> getAllPlanes() {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    List<Plane> planes = session.createQuery("from Plane", Plane.class).getResultList();
    currentTransaction.commit();
    session.close();
    return Optional.of(planes);
  }
  
  public Plane get(Long id) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    Plane plane = session.get(Plane.class, id);
    currentTransaction.commit();
    session.close();
    return plane;
  }

  public void createNewPlane(Plane plane) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    session.persist(plane);
    currentTransaction.commit();
    session.close();
  }
  
  public void deletePlane(Plane plane) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    session.delete(plane);
    currentTransaction.commit();
    session.close();
  }

  public void update(Plane plane) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    session.update(plane);
    currentTransaction.commit();
    session.close();
  }
}
