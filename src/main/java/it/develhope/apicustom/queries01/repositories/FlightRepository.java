package it.develhope.apicustom.queries01.repositories;

import it.develhope.apicustom.queries01.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FlightRepository extends JpaRepository<Flight,Long> {
}
