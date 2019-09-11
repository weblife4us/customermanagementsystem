package com.go2it.frame.config.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static com.go2it.frame.entity.Customer.Type;

/**
 * @author Alex Ryzhkov
 */
@Converter(autoApply = true)
public class PersonTypeConverter implements AttributeConverter<Type, String> {
	@Override
	public String convertToDatabaseColumn(Type type) {
		return type.getTitle();
	}

	@Override
	public Type convertToEntityAttribute(String s) {
		return Type.getByTitle(s);
	}
}
