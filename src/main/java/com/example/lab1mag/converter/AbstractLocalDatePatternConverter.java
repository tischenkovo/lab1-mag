package com.example.lab1mag.converter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;


public abstract class AbstractLocalDatePatternConverter extends AbstractBeanField<LocalDate, String> {

	protected abstract String getPattern();

	@Override
	protected LocalDate convert(String s) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getPattern());
		return LocalDate.parse(s, formatter);
	}

	@Override
	protected String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getPattern());
		return formatter.format((TemporalAccessor) value);
	}
}
