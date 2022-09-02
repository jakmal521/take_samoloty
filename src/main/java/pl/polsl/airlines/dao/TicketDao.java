package pl.polsl.airlines.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.polsl.airlines.model.Ticket;

import java.util.List;

public class TicketDao extends ObjectDao {
  private Session session;
  private Transaction currentTransaction;

  public List<Ticket> getAll() {
    return null;
  }

  public Ticket get(Long id) {
    return null;
  }

  public void create(Ticket ticket) {
    session = getSessionFactory().openSession();
    currentTransaction = session.beginTransaction();
    session.persist(ticket);
    currentTransaction.commit();
    session.close();
  }

  public void delete(Ticket ticketToDelete) {
  }
}
