package com.travelport.rest;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class RestObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 1L;

	public RestObjectMapper() {
		super.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		super.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		super.configure(MapperFeature.AUTO_DETECT_FIELDS, false);
		super.setSerializationInclusion(Include.NON_EMPTY);
	}
}
