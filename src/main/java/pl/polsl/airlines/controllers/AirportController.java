package pl.polsl.airlines.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.airlines.model.Airport;
import pl.polsl.airlines.requests.AirportCreateOrUpdateRequest;
import pl.polsl.airlines.services.AirportService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class AirportController {

  @Autowired
  private AirportService airportService;

  @GetMapping("/airports")
  List<Airport> getAll() {
    return airportService.getAll();
  }

  @GetMapping("/airports/{id}")
  public Airport get(@PathVariable("id") Long id) {
    return airportService.get(id);
  }

  @PostMapping("/airports")
  public void create(@Valid @NotNull @RequestBody AirportCreateOrUpdateRequest request) {
    airportService.create(request);
  }

  @DeleteMapping("/airports/{id}")
  public void delete(@PathVariable("id") Long id) {
    airportService.delete(id);
  }

  @PutMapping("/airports/{id}")
  public void update(@PathVariable("id") Long id, @Valid @NotNull @RequestBody AirportCreateOrUpdateRequest request) {
    airportService.update(id, request);
  }
}
