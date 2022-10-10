package com.example.lab1mag.converter;

public class MMDDYYYYLocalDateConverter extends AbstractLocalDatePatternConverter {
	@Override
	protected String getPattern() {
		return "MM-dd-yyyy";
	}
}
