package com.capstone.payments.service;

import java.util.List;

public interface ExportDataService {
	public List<String[]> createCsvData(int accountNo);
}
