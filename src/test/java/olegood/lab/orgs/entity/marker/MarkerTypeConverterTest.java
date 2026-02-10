package olegood.lab.orgs.entity.marker;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarkerTypeConverterTest {

  private final MarkerTypeConverter converter = new MarkerTypeConverter();

  @ParameterizedTest
  @CsvSource({
    "GOLD, Gold",
    "SILVER, Silver",
    "BRONZE, Bronze",
    "HUB_SPEC, HSpec",
    "TOUCH_SPEC, TSpec",
    "SELF_DRIVEN, SDriven"
  })
  void shouldConvertMarkerTypeToDatabaseColumn(MarkerType markerType, String expectedDbValue) {
    // when
    var result = converter.convertToDatabaseColumn(markerType);

    // then
    assertThat(result).isEqualTo(expectedDbValue);
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
  void shouldConvertDatabaseValueToMarkerType(String dbValue, MarkerType expectedMarkerType) {
    // when
    var result = converter.convertToEntityAttribute(dbValue);

    // then
    assertThat(result).isEqualTo(expectedMarkerType);
  }

  @Test
  void shouldThrowExceptionWhenDatabaseValueIsNull() {
    // expect
    assertThatThrownBy(() -> converter.convertToEntityAttribute(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Unknown marker type: null");
  }

  @Test
  void shouldThrowExceptionForInvalidDatabaseValue() {
    // expect
    assertThatThrownBy(() -> converter.convertToEntityAttribute("InvalidValue"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Unknown marker type: InvalidValue");
  }
}
