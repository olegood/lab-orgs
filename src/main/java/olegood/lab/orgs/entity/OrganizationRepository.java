package olegood.lab.orgs.entity;

import java.time.Instant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

  /**
   * Retrieves all organizations that have been modified after the specified date.
   *
   * @param modifiedDate the instant after which organizations should have been modified
   * @param pageable pagination information
   * @return a page of organizations modified after the given date
   */
  Page<Organization> findByLastModifiedDateAfter(Instant modifiedDate, Pageable pageable);
}
