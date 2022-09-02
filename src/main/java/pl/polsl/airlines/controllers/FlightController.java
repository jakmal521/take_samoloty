package pl.polsl.airlines.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.airlines.model.Flight;
import pl.polsl.airlines.requests.FlightCreateOrUpdateRequest;
import pl.polsl.airlines.services.FlightService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("flights")
public class FlightController {

    private final FlightService flightService = new FlightService();

    @GetMapping
    @Produces("application/json")
    public List<Flight> getAll() {
      return flightService.getAll();
    }

    @GetMapping("/{id}")
    @Produces("application/json")
    public Flight get(@PathVariable("id") Long id) {
      return flightService.get(id);
    }

    @PostMapping
    @Consumes("application/json")
    public void create(@Valid @NotNull @RequestBody FlightCreateOrUpdateRequest request) {
      flightService.create(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
      flightService.delete(id);
    }

    @PutMapping("/{id}")
    @Consumes("application/json")
    public void update(@PathVariable("id")Long id, @Valid @NotNull FlightCreateOrUpdateRequest request) {
      flightService.update(id, request);
    }

  }
