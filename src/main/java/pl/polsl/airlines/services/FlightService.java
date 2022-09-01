package pl.polsl.airlines.services;

import pl.polsl.airlines.dao.AirportDao;
import pl.polsl.airlines.dao.FlightDao;
import pl.polsl.airlines.dao.PlaneDao;
import pl.polsl.airlines.dao.TicketDao;
import pl.polsl.airlines.models.Airport;
import pl.polsl.airlines.models.Flight;
import pl.polsl.airlines.models.Plane;
import pl.polsl.airlines.requests.FlightCreateOrUpdateRequest;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class FlightService {

  private final FlightDao flightDao = new FlightDao();
  private final AirportDao airportDao = new AirportDao();
  private final PlaneDao planeDao = new PlaneDao();
  private final TicketDao ticketDao = new TicketDao();


  public List<Flight> getAll() {
    return flightDao.getAll();
  }

  public Flight get(Long id) {
    return flightDao.get(id);
  }

  public void create(FlightCreateOrUpdateRequest request) {
    Airport arrivalAirport = airportDao.get(request.getArrivalAirport());
    Airport departureAirport = airportDao.get(request.getDepartureAirport());
    Plane plane = planeDao.get(request.getPlane());
    if (arrivalAirport != null && departureAirport != null && plane != null) {
      Flight flight = new Flight()
              .setDate(Date.valueOf(request.getDate()))
              .setDepartureTime(Time.valueOf(request.getDepartureTime()))
              .setArrivalTime(Time.valueOf(request.getArrivalTime()))
              .setArrivalAirport(arrivalAirport)
              .setDepartureAirport(departureAirport)
              .setPlane(plane)
              .setTickets(new ArrayList<>());

      flightDao.create(
             flight
      );
    }
  }

  public void delete(Long id) {
    Flight flightToDelete = get(id);
    if (flightToDelete != null) {
      flightToDelete.getTickets().forEach(ticketDao::delete);
      flightDao.delete(flightToDelete);
    }
  }

  public void update(Long id, FlightCreateOrUpdateRequest request) {
  }
}
