package olegood.lab.orgs.entity.enrollment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import olegood.lab.orgs.entity.marker.Marker;

@Entity
@Table(name = "ENROLLMENT")
public class Enrollment {

  @Id
  @Column(name = "ID")
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "TYPE", nullable = false)
  private EnrollmentType type;

  @Enumerated(EnumType.STRING)
  @Column(name = "STATUS", nullable = false)
  private EnrollmentStatus status;

  @OneToMany
  @JoinColumn(name = "ENROLLMENT_ID")
  private List<Marker> markers;
}
