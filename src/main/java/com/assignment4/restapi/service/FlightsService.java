package com.assignment4.restapi.service;

import com.assignment4.restapi.persistence.Flight;
import com.assignment4.restapi.persistence.FlightsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightsService
{
    FlightsRepository repository;
    public FlightsService(FlightsRepository repository)
    {
        this.repository = repository;
    }

    // crud methods
    public List<Flight> getAll()
    {
        return this.repository.findAll();
    }

    public Flight getById(Integer flightId)
    {
        return this.repository.findById(flightId).get();
    }

    public Flight add(Flight flight)
    {
        return this.repository.save(flight);
    }


    public Flight update(Integer flightId, Flight flight)
    {
        Optional<Flight> f = this.repository.findById(flightId);

        if(f.isPresent())
        {
            f.get().setAirline(flight.getAirline());
            f.get().setPrice(flight.getPrice());
            f.get().setMaxPassengers(flight.getMaxPassengers());
            return this.repository.save(f.get());
        }
        throw new RuntimeException();
    }

    public void delete(Integer flightId)
    {
        this.repository.deleteById(flightId);
    }
}
