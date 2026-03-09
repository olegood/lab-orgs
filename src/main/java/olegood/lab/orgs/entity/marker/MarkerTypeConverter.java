package olegood.lab.orgs.entity.marker;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * JPA converter for {@link MarkerType} enum to enable seamless persistence and retrieval
 * of marker types in the database.
 *
 * @see MarkerType
 * @see AttributeConverter
 */
@Converter
public class MarkerTypeConverter implements AttributeConverter<MarkerType, String> {

  /**
   * Converts a {@link MarkerType} enum value to its string literal representation
   * for storage in the database.
   *
   * @param markerType the {@link MarkerType} enum value to convert; may be {@code null}
   * @return the string literal representation of the marker type, or {@code null}
   * if the input is {@code null}
   */
  @Override
  public String convertToDatabaseColumn(MarkerType markerType) {
    return markerType.getLiteral();
  }

  /**
   * Converts a string value from the database to its corresponding {@link MarkerType}
   * enum constant.
   *
   * @param dbData the string value retrieved from the database; may be {@code null}
   * @return the {@link MarkerType} enum constant matching the database value, or {@code null}
   * if the input is {@code null}
   */
  @Override
  public MarkerType convertToEntityAttribute(String dbData) {
    return MarkerType.fromLiteral(dbData);
  }
}
