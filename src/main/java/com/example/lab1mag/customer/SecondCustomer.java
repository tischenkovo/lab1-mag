package com.example.lab1mag.customers;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SecondCustomer extends AbstractCustomer{
    private String accountName;
    private SecondCustomerParams customerParams;
}
