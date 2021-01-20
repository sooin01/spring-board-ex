package com.my.app.common.model;

import org.apache.commons.beanutils.PropertyUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

public class ObjectPropertyFilter extends SimpleBeanPropertyFilter {

	private String getValue(Object value) {
		if (value == null) {
			return null;
		}

		return value.toString().replaceAll("[0-9]+", "***");
	}

	@Override
	public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer)
			throws Exception {
		String name = writer.getName();

		if (name.equals("id")) {
			Object value = PropertyUtils.getProperty(pojo, name);

			jgen.writeFieldName(name);
			jgen.writeObject(getValue(value));
			return;
		}

		super.serializeAsField(pojo, jgen, provider, writer);
	}

}
