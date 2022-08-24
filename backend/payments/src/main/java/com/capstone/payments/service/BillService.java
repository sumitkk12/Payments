package com.capstone.payments.service;

import com.capstone.payments.entities.*;

import java.util.*;

public interface BillService {
	List<RegBillers> getRegisteredBillers(int accountNo);
	RegBillers createNewRegisteredBillers(RegBillers regBiller);
}
