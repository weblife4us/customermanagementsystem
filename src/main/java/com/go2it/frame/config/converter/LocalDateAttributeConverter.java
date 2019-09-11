package com.go2it.frame.config.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * This class is used to convert the LocalData properties of entity objects to sql.date
 *
 * @author Alex Ryzhkov
 */
@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate locDate) {
		return locDate == null ? null : Date.valueOf(locDate);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date sqlDate) {
		return sqlDate == null ? null : sqlDate.toLocalDate();
	}
}