package com.example.lab1mag;

import com.example.lab1mag.generator.FirstCustomerGenerator;
import com.example.lab1mag.generator.SecondCustomerGenerator;

public class Lab1MagApplication {

    public static void main(String[] args) {
        new FirstCustomerGenerator().generateAndExportCustomers();
        new SecondCustomerGenerator().generateAndExportCustomers();
    }

}
