package pl.polsl.airlines.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;


@RestController
public class PlaneController {

  @GET
  @GetMapping("/plane")
  public String createPlane(){
    return "helloPlane";
  }
}
