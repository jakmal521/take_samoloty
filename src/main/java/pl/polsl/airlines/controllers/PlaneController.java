package pl.polsl.airlines.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.airlines.model.Plane;
import pl.polsl.airlines.requests.PlaneCreateOrUpdateRequest;
import pl.polsl.airlines.services.PlaneService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;


@RestController
@RequestMapping("planes")
public class PlaneController {

  private final PlaneService planeService = new PlaneService();

  @GetMapping
  @Produces("application/json")
  public ResponseEntity<List<Plane>> createPlane() {
    return ResponseEntity.ok(planeService.getAllPlanes().get());
  }

  @GetMapping("/{id}")
  @Produces("application/json")
  public Plane createPlane(@PathVariable("id") Long id) {
    return planeService.getPlaneById(id);
  }

  @PostMapping
  @Consumes("application/json")
  public void createPlane(@Valid @NotNull @RequestBody PlaneCreateOrUpdateRequest request) {
    planeService.createNewPlane(request);
  }

  @DeleteMapping("/{id}")
  public void deletePlane(@PathVariable("id") Long id) {
    planeService.deletePlane(id);
  }

  @PutMapping("/{id}")
  @Consumes("application/json")
  public void updatePlane(@PathVariable("id") Long id, @Valid @NotNull @RequestBody PlaneCreateOrUpdateRequest request) {
    planeService.updatePlane(id,request);
  }
}
