package org.hackunix.adapters.jsonb;

import java.time.LocalDate;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;

import org.hackunix.adapters.DateTimeFormats;

public class LocalDateJsonbAdapter implements JsonbAdapter<LocalDate, JsonString> {

	@Override
	public LocalDate adaptFromJson(JsonString value) throws Exception {
		return LocalDate.from(DateTimeFormats.middle_endian.parse(value.getChars()));
	}

	@Override
	public JsonString adaptToJson(LocalDate value) throws Exception {
		return Json.createValue(DateTimeFormats.middle_endian.format(value));
	}

}
