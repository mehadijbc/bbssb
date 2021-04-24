package bd.gov.jbc.eduins.service;

import java.util.List;

import bd.gov.jbc.eduins.entity.Invoice;

public interface IExcelDataService {

	List<Invoice> getExcelDataAsList();
	
	int saveExcelData(List<Invoice> invoices);
}
