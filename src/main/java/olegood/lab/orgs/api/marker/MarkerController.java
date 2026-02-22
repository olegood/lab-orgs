package olegood.lab.orgs.api.marker;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import olegood.lab.orgs.entity.marker.Marker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MarkerController {

  @Operation(
      summary = "Get markers for an enrollment",
      tags = {"Markers"})
  @GetMapping("/api/enrollments/{enrollmentId}/markers")
  public List<Marker> getMarkersForEnrollment(@PathVariable Long enrollmentId) {
    throw new UnsupportedOperationException("Not yet implemented.");
  }
}
