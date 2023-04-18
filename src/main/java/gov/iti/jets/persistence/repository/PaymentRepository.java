package gov.iti.jets.persistence.repository;

import gov.iti.jets.persistence.dao.PaymentDao;
import gov.iti.jets.persistence.daoImp.PaymentDaoImp;
import gov.iti.jets.service.dto.PaymentDto;

import java.util.List;

public class PaymentRepository implements PaymentDao {
    private PaymentDao paymentDao;
    public PaymentRepository() {
        paymentDao = new PaymentDaoImp();
    }

    @Override
    public PaymentDto getPaymentById(Short id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public List<PaymentDto> getAllPayment() {
        return paymentDao.getAllPayment();
    }
}
