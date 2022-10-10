package com.example.lab1mag.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SecondCustomer extends AbstractCustomer{
    private String accountName;
    private SecondCustomerParams customerParams;
}
