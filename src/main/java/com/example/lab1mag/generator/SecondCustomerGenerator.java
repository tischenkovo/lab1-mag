package com.example.lab1mag.generator;

import com.example.lab1mag.customer.SecondCustomer;
import com.example.lab1mag.customer.SecondCustomerParams;
import com.example.lab1mag.exporter.CsvExporter;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SecondCustomerGenerator implements CustomerGenerator{

    @Override
    public List<SecondCustomer> generateCustomers() {
        return getNames().stream().map(this::generateCustomer).collect(Collectors.toList());
    }

    private SecondCustomer generateCustomer(String name){
        var customer = new SecondCustomer();
        customer.setAccountName(name);
        customer.setCustomerParams(generateCustomerParams());
        return customer;
    }

    private SecondCustomerParams generateCustomerParams(){
        var random = new Random();
        SecondCustomerParams customerParams = new SecondCustomerParams();
        customerParams.setDate(LocalDate.ofEpochDay(random.nextLong(LocalDate.now().toEpochDay())));
        customerParams.setTrafficSizeMb(random.nextInt(Integer.MAX_VALUE));
        customerParams.setAddress(
            "City"
                + random.nextInt(100)
                + " Street"
                + random.nextInt(100)
                + " "
                + random.nextInt(100)
        );
        return customerParams;
    }

    private List<String> getNames(){
        return Arrays.asList("Saturn", "Mars", "Mercury",
                "Venus", "Earth", "Phobos", "Deimos", "Gaspra", "Jupiter", "Uranus", "Neptune", "Pluto", "Haumea");
    }

    @Override
    public void generateAndExportCustomers() {
        CsvExporter csvExporter = new CsvExporter();
        String className = SecondCustomer.class.getSimpleName().toLowerCase();
        generateCustomers().forEach(customer ->
            csvExporter.export(customer.getAccountName(), className,
                Collections.singletonList(customer.getCustomerParams()))
        );
    }
}
