package olegood.lab.orgs.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrganizationStatusTest {

  @DisplayName("Test that OrganizationStatus enum has 7 values")
  @Test
  void testStatusEnumValues() {
    assertThat(OrganizationStatus.values()).hasSize(7);
  }

  @DisplayName("Test that OrganizationStatus enum values are unique")
  @Test
  void testStatusEnumValuesUnique() {
    assertThat(OrganizationStatus.values()).doesNotHaveDuplicates();
  }
}
