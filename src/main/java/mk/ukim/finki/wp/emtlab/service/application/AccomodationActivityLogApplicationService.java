package mk.ukim.finki.wp.emtlab.service.application;

import mk.ukim.finki.wp.emtlab.model.dto.DisplayAccomodationActivityLogDto;
import org.springframework.data.domain.Page;

public interface AccomodationActivityLogApplicationService {
    Page<DisplayAccomodationActivityLogDto> findAll(int page, int size, String sortBy, String sortDirection);
}

