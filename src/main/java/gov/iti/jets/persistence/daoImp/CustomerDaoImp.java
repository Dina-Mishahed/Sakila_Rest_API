package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.CustomerDao;
import gov.iti.jets.service.dto.CustomerDto;
import gov.iti.jets.service.dto.PaymentDto;
import gov.iti.jets.service.dto.RentalDto;

import java.util.List;

public class CustomerDaoImp implements CustomerDao {
    @Override
    public CustomerDto getCustomerById(int id) {
        return null;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return null;
    }

    @Override
    public Boolean addCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public Boolean updateCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public CustomerDto getCustomerByName(String name) {
        return null;
    }

    @Override
    public List<RentalDto> getCustomerRentalById(int id) {
        return null;
    }

    @Override
    public List<RentalDto> getCustomerRentalByName(String name) {
        return null;
    }

    @Override
    public int getTotalAmountCustomerRental(int id) {
        return 0;
    }

    @Override
    public List<PaymentDto> getCustomerPaymentById(int id) {
        return null;
    }

    @Override
    public List<PaymentDto> getCustomerPaymentByName(int id) {
        return null;
    }

    @Override
    public int getNoOfCustomers() {
        return 0;
    }

    @Override
    public List<CustomerDto> getAllActiveCustomers() {
        return null;
    }

    @Override
    public List<CustomerDto> getAllInactiveCustomers() {
        return null;
    }
}
