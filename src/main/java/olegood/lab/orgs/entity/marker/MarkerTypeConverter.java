package olegood.lab.orgs.entity.marker;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class MarkerTypeConverter implements AttributeConverter<MarkerType, String> {

  @Override
  public String convertToDatabaseColumn(MarkerType markerType) {
    return markerType.getLiteral();
  }

  @Override
  public MarkerType convertToEntityAttribute(String dbData) {
    return MarkerType.fromLiteral(dbData);
  }
}
