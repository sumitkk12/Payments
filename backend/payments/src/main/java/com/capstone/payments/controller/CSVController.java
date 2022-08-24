package com.capstone.payments.controller;

import com.capstone.payments.serviceImpl.MailService;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.capstone.payments.serviceImpl.CSV.createCsvDataSimple;


@RestController
public class CSVController {
    @Autowired
    private CSVController CSV;

    @GetMapping("CSV/")
    @EventListener(ApplicationReadyEvent.class)
    public void GenerateCSV() throws IOException {
        List<String[]> csvData = createCsvDataSimple();

        // default all fields are enclosed in double quotes
        // default separator is a comma
        try (CSVWriter writer = new CSVWriter(new FileWriter("\\test\\test.csv"))) {
            writer.writeAll(csvData);
        }
    }


}

