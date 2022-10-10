package com.example.lab1mag.converter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MMDDYYYYLocalDateConverter extends LocalDatePatternConverter {
	@Override
	protected String getPattern() {
		return "MM-dd-yyyy";
	}
}
