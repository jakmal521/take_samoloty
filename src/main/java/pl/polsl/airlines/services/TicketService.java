package pl.polsl.airlines.services;

import org.springframework.transaction.annotation.Transactional;
import pl.polsl.airlines.dao.FlightDao;
import pl.polsl.airlines.dao.PassengerDao;
import pl.polsl.airlines.dao.TicketDao;
import pl.polsl.airlines.models.Flight;
import pl.polsl.airlines.models.Passenger;
import pl.polsl.airlines.models.Ticket;
import pl.polsl.airlines.requests.TicketCreateOrUpdateRequest;

import java.util.List;

@Transactional
public class TicketService {

  private final TicketDao ticketDao = new TicketDao();
  private final FlightDao flightDao = new FlightDao();
  private final PassengerDao passengerDao = new PassengerDao();

  public List<Ticket> getAll() {
    return ticketDao.getAll();
  }

  public Ticket get(Long id) {
    return ticketDao.get(id);
  }

  public void create(Long flightId, Long passengerId, TicketCreateOrUpdateRequest request) {
    Flight flight = flightDao.get(flightId);
    Passenger passenger = passengerDao.get(passengerId);
    if(flight != null && passenger != null && flight.canBookTicket()){
      Ticket ticket = new Ticket().setNumber(request.getSeat());
      ticketDao.create(
              new Ticket().setNumber(request.getSeat())
      );
      flight.getTickets().add(ticket);
      passenger.getTickets().add(ticket);
      flightDao.update(flight);
      passengerDao.update(passenger);
    }
  }

  public void delete(Long id) {
    Ticket ticketToDelete = get(id);
    if (ticketToDelete != null) {
      ticketDao.delete(ticketToDelete);
    }
  }

  public void update(Long id, TicketCreateOrUpdateRequest request) {
  }
}
