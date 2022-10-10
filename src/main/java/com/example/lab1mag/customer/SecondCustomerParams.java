package com.example.lab1mag.customer;


import com.example.lab1mag.converter.DDMMYYYYLocalDateConverter;
import com.example.lab1mag.converter.MMDDYYYYLocalDateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SecondCustomerParams extends AbstractCustomer{

    public static final String TRAFFIC_SIZE_MB = "Объем трафика, Мб";
    public static final String DATE = "DD-mm-yyyy";
    public static final String ADDRESS = "Адрес абонента";

    @CsvCustomBindByName(converter = DDMMYYYYLocalDateConverter.class, column = DATE)
    private LocalDate date;
    @CsvBindByName(column = TRAFFIC_SIZE_MB)
    private int trafficSizeMb;
    @CsvBindByName(column = ADDRESS)
    private String address;
}
