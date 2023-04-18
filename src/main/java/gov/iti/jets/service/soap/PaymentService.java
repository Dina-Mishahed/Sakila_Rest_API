package gov.iti.jets.service.soap;

import gov.iti.jets.persistence.repository.PaymentRepository;
import gov.iti.jets.service.dto.PaymentDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

import java.util.List;

public class PaymentService {
    private PaymentRepository paymentRepository = new PaymentRepository();

    @WebMethod(operationName = "FindPaymentById")
    public PaymentDto getPaymentById(@WebParam(name = "paymentId") short id){
        return paymentRepository.getPaymentById(id);
    }

    @WebMethod(operationName = "FindAllPayment")
    public List<PaymentDto> getAllPayment() {
        return paymentRepository.getAllPayment();
    }
}
