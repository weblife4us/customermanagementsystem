package com.go2it.frame.config.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Alex Ryzhkov
 */
@Converter
public class StringToIntAttributeConverter implements AttributeConverter<Integer, String> {
	@Override
	public String convertToDatabaseColumn(Integer date) {
		return String.valueOf(date);
	}

	@Override
	public Integer convertToEntityAttribute(String date) {
		try {
			return Integer.valueOf(date);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
