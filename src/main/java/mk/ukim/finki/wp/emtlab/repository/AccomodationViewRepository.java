package mk.ukim.finki.wp.emtlab.repository;

import mk.ukim.finki.wp.emtlab.model.domain.Accomodation;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.model.views.AccomodationView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationViewRepository extends JpaRepository<Accomodation, Long> {

	@Query(value = """
			select
				a.id as id,
				a.name as name,
				a.category as category,
				a.status as status,
				a.numRooms as numRooms,
				a.rented as rented,
				h.id as hostId,
				h.name as hostName,
				h.surname as hostSurname,
				c.id as hostCountryId,
				c.name as hostCountryName,
				a.createdAt as createdAt
			from Accomodation a
				join a.host h
				join h.country c
			where (:category is null or a.category = :category)
			  and (:hostId is null or h.id = :hostId)
			  and (:hostCountryId is null or c.id = :hostCountryId)
			  and (:numRooms is null or a.numRooms = :numRooms)
			  and (:rented is null or a.rented = :rented)
			""",
			countQuery = """
			select count(a)
			from Accomodation a
				join a.host h
				join h.country c
			where (:category is null or a.category = :category)
			  and (:hostId is null or h.id = :hostId)
			  and (:hostCountryId is null or c.id = :hostCountryId)
			  and (:numRooms is null or a.numRooms = :numRooms)
			  and (:rented is null or a.rented = :rented)
			""")
	Page<AccomodationView> findAllFiltered(
			@Param("category") Category category,
			@Param("hostId") Long hostId,
			@Param("hostCountryId") Long hostCountryId,
			@Param("numRooms") Integer numRooms,
			@Param("rented") Boolean rented,
			Pageable pageable
	);
}
