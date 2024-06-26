package br.edu.uepb.sigeris.converters;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Extraído de https://thoughts-on-java.org/persist-localdate-localdatetime-jpa/
 * @author cassio
 *
 */
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
		return locDateTime == null ? null : Timestamp.valueOf(locDateTime);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
		return sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime();
	}
}
