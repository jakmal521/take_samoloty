package pl.polsl.airlines.services;


import org.springframework.stereotype.Service;
import pl.polsl.airlines.dao.AirportDao;
import pl.polsl.airlines.model.Airport;
import pl.polsl.airlines.requests.AirportCreateOrUpdateRequest;

import java.util.List;

@Service
public class AirportService {

  private final AirportDao airportDao = new AirportDao();

  public List<Airport> getAll() {
    return airportDao.getAll().get();
  }

  public Airport get(Long id) {
    return airportDao.get(id);
  }

  public void create(AirportCreateOrUpdateRequest request) {
    airportDao.create(
            new Airport().setAirportName(request.getAirportName()).setCity(request.getCity())
    );
  }

  public void delete(Long id) {
    Airport planeToDelete = get(id);
    if (planeToDelete != null) {
      airportDao.delete(planeToDelete);
    }
  }

  public void update(Long id, AirportCreateOrUpdateRequest request) {
    Airport airport = airportDao.get(id);
    if (airport == null) {
      airportDao.create(new Airport().setId(id).setAirportName(request.getAirportName()).setCity(request.getCity()));
    } else {
      airportDao.update(airport.setAirportName(request.getAirportName()).setCity(request.getCity()));
    }
  }

}
