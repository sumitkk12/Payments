package com.capstone.payments.serviceImpl;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CSV {
    public static void main(String[] args) throws IOException {

        List<String[]> csvData = createCsvDataSimple();

        // default all fields are enclosed in double quotes
        // default separator is a comma
        try (CSVWriter writer = new CSVWriter(new FileWriter("c:\\test\\test.csv"))) {
            writer.writeAll(csvData);
        }

    }

    private static List<String[]> createCsvDataSimple() {
        String[] header = {"Biller Name", "Customer Number", "Bill Amount", "Bill Date"};
        String[] record1 = {"Airtel", "218...", "2131", "12/01/2022"};
        String[] record2 = {"Jio", "213..", "1200", "01/02/2023"};

        List<String[]> list = new ArrayList<>();
        list.add(header);
        list.add(record1);
        list.add(record2);

        return list;
    }

}