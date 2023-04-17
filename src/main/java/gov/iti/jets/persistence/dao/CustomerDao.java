package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.CustomerDto;
import gov.iti.jets.service.dto.PaymentDto;
import gov.iti.jets.service.dto.RentalDto;

import java.util.List;

public interface CustomerDao {
    CustomerDto getCustomerById(int id);
    List<CustomerDto> getAllCustomers();
    Boolean addCustomer(CustomerDto customerDto);
    Boolean updateCustomer(CustomerDto customerDto);
    List<CustomerDto> getCustomersByName(String name);
    List<RentalDto> getCustomerRentalById(int id);
    List<PaymentDto> getCustomerPaymentById(int id);
    List<CustomerDto> getAllActiveCustomers();
    List<CustomerDto> getAllInactiveCustomers();

}
