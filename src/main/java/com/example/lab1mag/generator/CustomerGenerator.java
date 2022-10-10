package com.example.lab1mag.generator;


import com.example.lab1mag.customer.AbstractCustomer;

import java.util.List;

public interface CustomerGenerator <T extends AbstractCustomer>{

     List<T> generateCustomers();

     void generateAndExportCustomers();

}
