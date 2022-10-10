package com.example.lab1mag.customers;


import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SecondCustomerParams extends AbstractCustomer{

    public static final String TRAFFIC_SIZE_MB = "Объем трафика, Мб";
    public static final String DATE = "DD-mm-yyyy";
    public static final String ADDRESS = "Адрес абонента";

    @CsvBindByName(column = DATE)
    private LocalDate date;
    @CsvBindByName(column = TRAFFIC_SIZE_MB)
    private int trafficSizeMb;
    @CsvBindByName(column = ADDRESS)
    private String address;
}
