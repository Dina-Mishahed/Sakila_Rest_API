package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.PaymentDto;

import java.util.List;

public interface PaymentDao {
    public PaymentDto getPaymentById(Short id);
    public List<PaymentDto> getAllPayment();
}
