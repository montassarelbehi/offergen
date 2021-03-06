package offergen.logic.converters;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime x) {
		return x == null ? null : Timestamp.valueOf(x);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp x) {
		return x == null ? null : x.toLocalDateTime();
	}
}