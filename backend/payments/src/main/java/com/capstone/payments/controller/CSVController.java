package com.capstone.payments.controller;

import com.capstone.payments.service.ExportDataService;
import com.capstone.payments.serviceImpl.CSV;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RestController
public class CSVController {
    @Autowired
    public ExportDataService exportDataService;

    @GetMapping("CSV/{accountNo}")
    public void GenerateCSV(@PathVariable int accountNo) throws IOException {
        List<String[]> csvData = exportDataService.createCsvData(accountNo);
        
        // default all fields are enclosed in double quotes
        // default separator is a comma
        try (CSVWriter writer = new CSVWriter(
                new FileWriter("C:\\Users\\Admin\\OneDrive\\Desktop\\Payments\\backend\\payments\\src\\test\\test.csv"))) {
            writer.writeAll(csvData);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}