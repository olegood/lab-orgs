package olegood.lab.orgs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.List;

import jakarta.validation.constraints.Min;
import olegood.lab.orgs.entity.enrollment.Enrollment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = Organization.TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
public class Organization {

  public static final String TABLE_NAME = "ORGANIZATION";

  @Id
  @Column(name = "ID", unique = true)
  private Long id;

  @Column(name = "CODE", length = 15, unique = true)
  private String code;

  @Column(name = "NAME", length = 64, nullable = false)
  private String name;

  @Column(name = "WEBSITE", length = 64)
  private String website;

  @Column(name = "COUNTRY", length = 64, nullable = false)
  private String country;

  @Column(name = "DESCRIPTION", length = 300)
  private String description;

  @Min(1970)
  @Column(name = "FOUNDED")
  private int founded;

  @Column(name = "INDUSTRY", length = 100, nullable = false)
  private String industry;

  @Min(1)
  @Column(name = "NUMBER_OF_EMPLOYEES")
  private int numberOfEmployees;

  @Enumerated(EnumType.STRING)
  @Column(name = "STATUS", nullable = false)
  private OrganizationStatus status;

  @OneToMany
  @JoinColumn(name = "ORGANIZATION_ID")
  private List<Enrollment> enrollments;

  @CreatedDate
  @Column(name = "CREATED_DATE", nullable = false, updatable = false)
  private Instant createdDate;

  @LastModifiedDate
  @Column(name = "LAST_MODIFIED_DATE", nullable = false)
  private Instant lastModifiedDate;
}
