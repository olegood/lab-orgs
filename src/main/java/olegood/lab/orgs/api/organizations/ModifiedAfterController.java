package olegood.lab.orgs.api.organizations;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import java.time.Instant;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import olegood.lab.orgs.entity.Organization;
import olegood.lab.orgs.entity.OrganizationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/organizations")
public class ModifiedAfterController {

  private final OrganizationRepository organizationRepository;

  @Operation(
      summary = "Get organizations modified after a specific date",
      tags = {"Organizations"})
  @GetMapping("/modified-after")
  public Page<Organization> getOrganizationsModifiedAfter(
      @Parameter(
              description = "ISO 8601 date-time format (e.g., 2024-01-15T10:30:00Z)",
              examples = {
                @ExampleObject(name = "Specific date and time", value = "2024-01-15T10:30:00Z"),
                @ExampleObject(name = "With milliseconds", value = "2024-03-20T14:45:30.500Z"),
                @ExampleObject(name = "With timezone offset", value = "2024-02-10T08:00:00-05:00"),
                @ExampleObject(name = "Start of day", value = "2024-01-01T00:00:00Z")
              })
          @RequestParam(required = false)
          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
          Optional<Instant> lastModifiedDate,
      @PageableDefault(size = 20, sort = "code") Pageable pageable) {
    return lastModifiedDate
        .map(date -> organizationRepository.findByLastModifiedDateAfter(date, pageable))
        .orElseGet(() -> organizationRepository.findAll(pageable));
  }
}
