package bd.gov.jbc.eduins.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bd.gov.jbc.eduins.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}