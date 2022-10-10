package com.example.lab1mag.customers;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FirstCustomer extends AbstractCustomer {

    public static final String ACCOUNT_NAME = "Уникальное имя абонента (AccountName)";
    public static final String TRAFFIC_SIZE_KB = "Объем трафика, Кб";
    public static final String DATE = "mm-DD-yyyy";
    public static final String CITY = "город";
    public static final String STREET = "улица";
    public static final String HOUSE = "дом";

    @CsvBindByName(column = ACCOUNT_NAME)
    private String accountName;
    @CsvBindByName(column = TRAFFIC_SIZE_KB)
    private int trafficSizeKb;
    @CsvBindByName(column = DATE)
    private LocalDate date;
    @CsvBindByName(column = CITY)
    private String city;
    @CsvBindByName(column = STREET)
    private String street;
    @CsvBindByName(column = HOUSE)
    private String house;
}
