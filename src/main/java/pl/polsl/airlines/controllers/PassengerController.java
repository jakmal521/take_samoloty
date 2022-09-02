package pl.polsl.airlines.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.airlines.model.Passenger;
import pl.polsl.airlines.requests.PassengerCreateOrUpdateRequest;
import pl.polsl.airlines.services.PassengerService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("passengers")
public class PassengerController {

  private final PassengerService passengerService = new PassengerService();

  @GetMapping
  @Produces("application/json")
  public List<Passenger> getAll() {
    return passengerService.getAll();
  }

  @GetMapping("/{id}")
  @Produces("application/json")
  public Passenger get(@PathVariable("id") Long id) {
    return passengerService.get(id);
  }

  @PostMapping
  @Consumes("application/json")
  public void create(@Valid @NotNull @RequestBody PassengerCreateOrUpdateRequest request) {
    passengerService.create(request);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    passengerService.delete(id);
  }

  @PutMapping("/{id}")
  @Consumes("application/json")
  public void update(@PathVariable long id, @Valid @NotNull PassengerCreateOrUpdateRequest request) {
    passengerService.update(id, request);
  }

}
