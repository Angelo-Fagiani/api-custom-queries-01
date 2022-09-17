package it.develhope.apicustom.queries01.controller;

import it.develhope.apicustom.queries01.entities.Flight;
import it.develhope.apicustom.queries01.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static it.develhope.apicustom.queries01.entities.FlightStatus.ON_TIME;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;
    public String generateRandomValueForFlight(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    @GetMapping("/loadFlight")
    public List<Flight> randomFlight() {
        List<Flight> randomFlight = new ArrayList<>();
        for (int i = 0; i <= 50; i++) {
            randomFlight.add(new Flight(i, generateRandomValueForFlight(), generateRandomValueForFlight(), generateRandomValueForFlight(),ON_TIME));
        }
        flightRepository.saveAllAndFlush(randomFlight);
        return randomFlight;
    }

    @GetMapping("")
    public List<Flight> getFlights () {
        return flightRepository.findAll();
        }

    }
