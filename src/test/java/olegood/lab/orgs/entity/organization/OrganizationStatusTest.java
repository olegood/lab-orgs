package olegood.lab.orgs.entity.organization;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrganizationStatusTest {

  @DisplayName("Enumeration has expected number of values")
  @Test
  void testStatusEnumValues() {
    // expect
    assertThat(OrganizationStatus.values()).hasSize(7);
  }

  @DisplayName("Enumeration values are unique")
  @Test
  void testStatusEnumValuesUnique() {
    // expect
    assertThat(OrganizationStatus.values()).doesNotHaveDuplicates();
  }
}
