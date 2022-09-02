package pl.polsl.airlines.services;

import pl.polsl.airlines.dao.PlaneDao;
import pl.polsl.airlines.model.Plane;
import pl.polsl.airlines.requests.PlaneCreateOrUpdateRequest;

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

  public void createNewPlane(PlaneCreateOrUpdateRequest request) {
    planeDao.createNewPlane(new Plane(request.getModel(), request.getSeats()));
  }

  public void deletePlane(Long id) {
    Plane planeToDelete = getPlaneById(id);
    if (planeToDelete != null) {
      planeDao.deletePlane(planeToDelete);
    }
  }

  public void updatePlane(Long id, PlaneCreateOrUpdateRequest request){
    Plane planeToUpdate = getPlaneById(id);
    if (planeToUpdate != null) {
      planeToUpdate.setModel(request.getModel());
      planeToUpdate.setSeats(request.getSeats());
      planeDao.update(planeToUpdate);
    } else {
      planeDao.createNewPlane(new Plane(request.getModel(), request.getSeats()));
    }
  }
}
