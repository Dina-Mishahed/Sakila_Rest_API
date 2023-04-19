package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.PaymentRepository;
import gov.iti.jets.service.dto.PaymentDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("payment")
public class PaymentResource {
    private PaymentRepository paymentRepository = new PaymentRepository();

    @GET
    @Path("{paymentId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public PaymentDto getPaymentById(@PathParam("paymentId") short id){
        return paymentRepository.getPaymentById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PaymentDto> getAllPayment() {
        return paymentRepository.getAllPayment();
    }
}
