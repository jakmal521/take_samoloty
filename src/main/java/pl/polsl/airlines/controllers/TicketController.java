package pl.polsl.airlines.controllers;

  import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.airlines.models.Ticket;
import pl.polsl.airlines.requests.TicketCreateOrUpdateRequest;
import pl.polsl.airlines.services.TicketService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import java.util.List;

@RestController
@RequestMapping("tickets")
public class TicketController {

  private final TicketService ticketService = new TicketService();

  @GetMapping
  @Produces("application/json")
  public List<Ticket> getAll() {
    return ticketService.getAll();
  }

  @GetMapping("/{id}")
  @Produces("application/json")
  public Ticket get(@PathVariable("id") Long id) {
    return ticketService.get(id);
  }

  @PostMapping("/{flightId}/{passengerId}")
  @Consumes("application/json")
  public void create(@Valid @NotNull TicketCreateOrUpdateRequest request, @PathVariable Long flightId, @PathVariable Long passengerId) {
    ticketService.create(flightId, passengerId, request);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    ticketService.delete(id);
  }

  @PutMapping("/{id}")
  @Consumes("application/json")
  public void update(@PathVariable("id") Long id, @Valid @NotNull TicketCreateOrUpdateRequest request) {
    ticketService.update(id, request);
  }

}
