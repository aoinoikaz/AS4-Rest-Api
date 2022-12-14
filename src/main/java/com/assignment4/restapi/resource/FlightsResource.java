package com.assignment4.restapi.resource;

import com.assignment4.restapi.persistence.Flight;
import com.assignment4.restapi.service.FlightsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightsResource
{
    FlightsService service;

    public FlightsResource(FlightsService service)
    {
        this.service = service;
    }

    @GetMapping(value = "/flight")
    public List<Flight> getAll()
    {
        return this.service.getAll();
    }

    @GetMapping(value = "/flight/{flightId}")
    public Flight getById(@PathVariable Integer flightId)
    {
        return this.service.getById(flightId);
    }

    @PostMapping(value = "/flight")
    public Flight add(Flight flight)
    {
        return this.service.add(flight);
    }

    @PutMapping(value = "/flight/{flightId}", consumes = "application/json")
    public Flight update(@PathVariable Integer flightId, @RequestBody Flight flight)
    {
        return this.service.update(flightId, flight);
    }

    @DeleteMapping(value = "/flight/{flightId}")
    public void delete(@PathVariable Integer flightId)
    {
        this.service.delete(flightId);
    }
}
