package mk.ukim.finki.wp.emtlab.repository;

import mk.ukim.finki.wp.emtlab.model.domain.Reservation;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Override
    @EntityGraph(value = "reservation.user-and-accomodation", type = EntityGraph.EntityGraphType.FETCH)
    List<Reservation> findAll();

    @Override
    @EntityGraph(value = "reservation.user-and-accomodation", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Reservation> findById(Long id);

    boolean existsByUserId(Long userId);

    boolean existsByAccomodationId(Long accomodationId);
}

