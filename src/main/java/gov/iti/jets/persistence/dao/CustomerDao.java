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
    CustomerDto getCustomerByName(String name);
    List<RentalDto> getCustomerRentalById(int id);
    List<RentalDto> getCustomerRentalByName(String name);
    int getTotalAmountCustomerRental(int id);
    List<PaymentDto> getCustomerPaymentById(int id);
    List<PaymentDto> getCustomerPaymentByName(int id);
    int getNoOfCustomers();
    List<CustomerDto> getAllActiveCustomers();
    List<CustomerDto> getAllInactiveCustomers();

}
