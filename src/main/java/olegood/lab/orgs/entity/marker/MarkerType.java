package olegood.lab.orgs.entity.marker;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MarkerType {
  GOLD("Gold"),
  SILVER("Silver"),
  BRONZE("Bronze"),

  HUB_SPEC("HSpec"),
  TOUCH_SPEC("TSpec"),
  SELF_DRIVEN("SDriven");

  private final String literal;

  /**
   * Converts a string literal to its corresponding {@link MarkerType} enum value.
   * The comparison is case-sensitive and matches the literal value of each enum.
   *
   * @param literal the string representation of the marker type
   * @return the {@link MarkerType} corresponding to the provided literal
   * @throws IllegalArgumentException if no matching {@link MarkerType} is found
   */
  public static MarkerType fromLiteral(String literal) {
    return Arrays.stream(values())
        .filter(type -> type.getLiteral().equals(literal))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Unknown marker type: " + literal));
  }
}
