package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.CountryRepository;
import gov.iti.jets.persistence.repository.CustomerRepository;
import gov.iti.jets.service.dto.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("cusomers")
public class CustomerResource {

    private CustomerRepository customerRepository = new  CustomerRepository();

    @GET
    @Path("{customerId: [0-9]+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public CustomerDto getCustomerById(@PathParam("customerId") int id) {
        return customerRepository.getCustomerById(id);
    }

    @GET
    @Path("getAllCustomers")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @POST
    @Path("addCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean addCustomer(CustomerDto customerDto) {
        return customerRepository.addCustomer(customerDto);
    }

    @GET
    @Path("{customerName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<CustomerDto> getCustomersByName(@PathParam("customerName")String name){
        return customerRepository.getCustomersByName(name);
    }


    @GET
    @Path("getCustomers/{customerId: [0-9]+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<RentalDto> getCustomerRentalById(@PathParam("customerId")int id){
        return customerRepository.getCustomerRentalById(id);
    }

    @GET
    @Path("getPayment/{customerId: [0-9]+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<PaymentDto> getCustomerPaymentById(@PathParam("customerId")int id){
        return customerRepository.getCustomerPaymentById(id);
    }
    @GET
    @Path("getActiveCustomers")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<CustomerDto> getAllActiveCustomers(){
        return customerRepository.getAllActiveCustomers();
    }


    @GET
    @Path("getInactiveCustomers")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<CustomerDto> getAllInactiveCustomers() {
        return customerRepository.getAllInactiveCustomers();
    }
}