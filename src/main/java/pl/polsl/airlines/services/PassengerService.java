package pl.polsl.airlines.services;

import pl.polsl.airlines.dao.PassengerDao;

import pl.polsl.airlines.models.Passenger;
import pl.polsl.airlines.requests.PassengerCreateOrUpdateRequest;

import java.util.List;

public class PassengerService {

  private final PassengerDao passengerDao = new PassengerDao();

  public List<Passenger> getAll() {
    return passengerDao.getAll();
  }

  public Passenger get(Long id) {
    return passengerDao.get(id);
  }

  public void create(PassengerCreateOrUpdateRequest request) {
    passengerDao.create(
            new Passenger().setName(request.getName()).setSurname(request.getSurname())
    );
  }

  public void delete(Long id) {
    Passenger passengerToDelete = get(id);
    if (passengerToDelete != null) {
      passengerDao.delete(passengerToDelete);
    }
  }

  public void update(Long id, PassengerCreateOrUpdateRequest request) {
    passengerDao.update(
            new Passenger().setId(id).setName(request.getName()).setSurname(request.getSurname())
    );
  }
}
