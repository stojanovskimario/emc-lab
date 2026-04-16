package mk.ukim.finki.wp.emtlab.repository;

import jakarta.persistence.EntityManagerFactory;
import mk.ukim.finki.wp.emtlab.config.JpaConfig;
import mk.ukim.finki.wp.emtlab.model.domain.Accomodation;
import mk.ukim.finki.wp.emtlab.model.domain.Country;
import mk.ukim.finki.wp.emtlab.model.domain.Host;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.model.enums.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(JpaConfig.class)
@Transactional
class AccomodationRepositoryEntityGraphTest {

    @Autowired
    private AccomodationRepository accomodationRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private HostRepository hostRepository;

    @Autowired
    private org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager entityManager;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    void findByIdShouldLoadHostAndCountryUsingEntityGraph() {
        Country country = countryRepository.save(new Country("Germany", "Europe"));
        Host host = hostRepository.save(new Host("John", "Doe", country));
        Accomodation accomodation = accomodationRepository.save(
                new Accomodation("City Apartment", Category.APARTMENT, host, Status.GOOD, 3, false)
        );

        entityManager.flush();
        entityManager.clear();

        Accomodation found = accomodationRepository.findById(accomodation.getId()).orElseThrow();

        assertThat(entityManagerFactory.getPersistenceUnitUtil().isLoaded(found.getHost())).isTrue();
        assertThat(entityManagerFactory.getPersistenceUnitUtil().isLoaded(found.getHost().getCountry())).isTrue();
        assertThat(found.getHost().getCountry().getName()).isEqualTo("Germany");
    }
}

