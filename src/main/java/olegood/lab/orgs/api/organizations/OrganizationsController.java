package olegood.lab.orgs.api.organizations;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import olegood.lab.orgs.entity.Organization;
import olegood.lab.orgs.entity.OrganizationRepository;
import olegood.lab.orgs.entity.enrollment.Enrollment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/organizations")
public class OrganizationsController {

  private final OrganizationRepository organizationRepository;

  @Operation(
      summary = "Get all organizations",
      tags = {"Organizations"})
  @GetMapping
  public Page<Organization> getAllOrganizations(Pageable pageable) {
    throw new UnsupportedOperationException("Not yet implemented.");
  }

  @Operation(
      summary = "Get organization by id",
      tags = {"Organizations"})
  @GetMapping("/{organizationId}")
  public Organization getOrganizationById(@PathVariable Long organizationId) {
    throw new UnsupportedOperationException("Not yet implemented.");
  }

  @Operation(
      summary = "Get enrollments for organization",
      tags = {"Organizations"})
  @GetMapping("/{organizationId}/enrollments")
  public List<Enrollment> getEnrollmentsForOrganization(@PathVariable Long organizationId) {
    throw new UnsupportedOperationException("Not yet implemented.");
  }
}
