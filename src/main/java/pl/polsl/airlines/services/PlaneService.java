package pl.polsl.airlines.services;

import pl.polsl.airlines.dao.PlaneDao;
import pl.polsl.airlines.models.Plane;

import java.util.List;
import java.util.Optional;

public class PlaneService {

  PlaneDao planeDao;

  public PlaneService() {
    this.planeDao = new PlaneDao();
  }

  public Optional<List<Plane>> getAllPlanes() {
    return planeDao.getAllPlanes();
  }

  public Plane getPlaneById(Long id) {
    return planeDao.get(id);
  }

  public void createNewPlane(String model, int seats) {
    planeDao.createNewPlane(new Plane(model, seats));
  }

  public void deletePlane(Long id) {
    Plane planeToDelete = getPlaneById(id);
    if (planeToDelete != null) {
      planeDao.deletePlane(planeToDelete);
    }
  }

  public void updatePlane(Long id,String model, int seats){
    Plane planeToUpdate = getPlaneById(id);
    if (planeToUpdate != null) {
      planeToUpdate.setModel(model);
      planeToUpdate.setSeats(seats);
      planeDao.update(planeToUpdate);
    } else {
      createNewPlane(model, seats);
    }
  }
}
