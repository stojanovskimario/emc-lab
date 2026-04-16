package mk.ukim.finki.wp.emtlab.web.controller;

import mk.ukim.finki.wp.emtlab.model.dto.DisplayAccomodationViewDto;
import mk.ukim.finki.wp.emtlab.service.application.AccomodationViewApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accomodations/view")
public class AccomodationViewController {

	private final AccomodationViewApplicationService accomodationViewApplicationService;

	public AccomodationViewController(AccomodationViewApplicationService accomodationViewApplicationService) {
		this.accomodationViewApplicationService = accomodationViewApplicationService;
	}

	@GetMapping("/paginated")
	public ResponseEntity<Page<DisplayAccomodationViewDto>> findAll(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "name") String sortBy,
			@RequestParam(defaultValue = "asc") String sortDirection
	) {
		return ResponseEntity.ok(
				accomodationViewApplicationService.findAll(
						page,
						size,
						sortBy,
						sortDirection
				)
		);
	}
}
