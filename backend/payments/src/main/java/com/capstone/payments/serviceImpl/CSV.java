package com.capstone.payments.serviceImpl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CSV {

    public List<String[]> createCsvDataSimple() {
        String[] header = { "Biller Name", "Customer Number", "Bill Amount", "Bill Date" };
        String[] record1 = { "Airtel", "218...", "2131", "12/01/2022" };
        String[] record2 = { "Jio", "213..", "1200", "01/02/2023" };

        List<String[]> list = new ArrayList<>();
        list.add(header);
        list.add(record1);
        list.add(record2);

        return list;
    }

}