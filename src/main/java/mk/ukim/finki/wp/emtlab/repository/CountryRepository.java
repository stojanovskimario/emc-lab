package mk.ukim.finki.wp.emtlab.repository;

import mk.ukim.finki.wp.emtlab.model.domain.Country;
import mk.ukim.finki.wp.emtlab.model.projection.CountryHostStatisticsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

	@Query(value = """
		select c.id as countryId,
			   c.name as countryName,
			   count(h.id) as hostCounter
		from countries c
				 left join hosts h on h.country_id = c.id
		group by c.id, c.name
		order by count(h.id) desc, c.name asc
		""", nativeQuery = true)
	List<CountryHostStatisticsProjection> findHostStatistics();
}
