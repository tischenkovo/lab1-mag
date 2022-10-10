package com.example.lab1mag.converter;

public class DDMMYYYYLocalDateConverter extends AbstractLocalDatePatternConverter {
	@Override
	protected String getPattern() {
		return "dd-MM-yyyy";
	}
}
