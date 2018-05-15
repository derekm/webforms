package org.hackunix.adapters.jaxb;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.hackunix.adapters.DateTimeFormats;

public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate> {

	@Override
	public String marshal(LocalDate value) throws Exception {
		return DateTimeFormats.middle_endian.format(value);
	}

	@Override
	public LocalDate unmarshal(String value) throws Exception {
		return LocalDate.from(DateTimeFormats.middle_endian.parse(value));
	}

}
