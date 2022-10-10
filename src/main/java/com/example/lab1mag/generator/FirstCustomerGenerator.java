package com.example.lab1mag.generator;

import com.example.lab1mag.customer.FirstCustomer;
import com.example.lab1mag.exporter.CsvExporter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FirstCustomerGenerator implements CustomerGenerator<FirstCustomer> {

    private final List<String> names = Arrays.asList("Saturn", "Mars", "Mercury",
        "Venus", "Earth", "Phobos", "Deimos", "Gaspra", "Jupiter", "Uranus", "Neptune", "Pluto", "Haumea");

    @Override
    public List<FirstCustomer> generateCustomers() {
        return getNames().stream().map(this::generateCustomer).collect(Collectors.toList());
    }

    private FirstCustomer generateCustomer(String name){
        var random = new Random();
        var customer = new FirstCustomer();
        customer.setAccountName(name);
        customer.setDate(LocalDate.ofEpochDay(random.nextLong(LocalDate.now().toEpochDay())));
        customer.setCity("City" + random.nextInt(100));
        customer.setStreet("Street" + random.nextInt(100));
        customer.setHouse(String.valueOf(random.nextInt(100)));
        customer.setTrafficSizeKb(random.nextInt(Integer.MAX_VALUE));
        return customer;
    }

    private List<String> getNames(){
        return names;
    }

    @Override
    public void generateAndExportCustomers() {
        CsvExporter csvExporter = new CsvExporter();
        csvExporter.export(FirstCustomer.class, generateCustomers());
    }
}
