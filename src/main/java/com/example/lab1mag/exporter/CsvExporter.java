package com.example.lab1mag.exporter;

import com.example.lab1mag.customer.AbstractCustomer;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvExporter {
    public static final String CSV_PATH = "./input_csv/";
    public static final String CSV_EXTENSION = ".csv";
    public static final String PATH_DELIMITER = "/";

    private <T> CSVWriter getCsvWriter(String fileName, String subDir) throws IOException {
        FileWriter writer;
        File path = new File(CSV_PATH + subDir + PATH_DELIMITER);
        File file = new File(path.getPath() + PATH_DELIMITER + fileName + CSV_EXTENSION);
        if (!file.exists() && path.mkdirs() && !file.createNewFile()) {
            throw new IOException(String.format("Невозможно создать файл с именнем %s", file.getName()));
        }
        writer = new FileWriter(file);
        return new CSVWriter(writer);
    }

    private <T> void deleteFile(String fileName) {
        new File(CSV_PATH + fileName + CSV_EXTENSION).delete();
    }

    public <T extends AbstractCustomer> void export(Class<T> tClass, List<T> objectList) {
        String className = tClass.getSimpleName().toLowerCase();
        export(className, className, objectList);
    }

    public <T extends AbstractCustomer> void export(String fileName, String subDir, List<T> objectList) {
        List<T> tList;
        tList = objectList;
        if (tList.isEmpty()) {
            deleteFile(fileName);
        }
        try (CSVWriter csvWriter = getCsvWriter(fileName, subDir)){
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(csvWriter)
                .withApplyQuotesToAll(false)
                .build();
            beanToCsv.write(tList);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException ignored) {
        }
    }
}
