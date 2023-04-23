package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.RentalRepository;
import gov.iti.jets.service.dto.PaymentDto;
import gov.iti.jets.service.dto.RentalDto;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("rentals")

public class RentalResource {
    private RentalRepository rentalRepository = new RentalRepository();

    @GET
    @Path("{rentalId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public RentalDto getRentalById(@PathParam("rentalId") short id){
        return rentalRepository.getRentalById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RentalDto> getAllRental() {
        return rentalRepository.getAllRental();
    }


    @GET
    @Path("getPayments/{storetId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PaymentDto> getPaymentListByRental(int id) {
        return rentalRepository.getPaymentListByRental(id);
    }
}
