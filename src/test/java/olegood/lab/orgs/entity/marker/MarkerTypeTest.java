package olegood.lab.orgs.entity.marker;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class MarkerTypeTest {

  @DisplayName("Enumeration has expected number of values")
  @Test
  void testStatusEnumValues() {
    // expect
    assertThat(MarkerType.values()).hasSize(6);
  }

  @ParameterizedTest
  @CsvSource({
    "Gold, GOLD",
    "Silver, SILVER",
    "Bronze, BRONZE",
    "HSpec, HUB_SPEC",
    "TSpec, TOUCH_SPEC",
    "SDriven, SELF_DRIVEN"
  })
  void fromLiteralShouldReturnCorrectMarkerType(String literal, MarkerType expected) {
    // when
    var result = MarkerType.fromLiteral(literal);

    // then
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = {"UnknownLiteral", "Invalid"})
  void fromLiteralShouldThrowExceptionWhenLiteralIsInvalid(String literal) {
    // expect
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> MarkerType.fromLiteral(literal))
        .withMessage("Unknown marker type: " + literal);
  }
}
