package gov.iti.jets.persistence.repository;

import gov.iti.jets.persistence.dao.CustomerDao;
import gov.iti.jets.persistence.daoImp.CustomerDaoImp;
import gov.iti.jets.service.dto.CustomerDto;
import gov.iti.jets.service.dto.PaymentDto;
import gov.iti.jets.service.dto.RentalDto;

import java.util.List;

public class CustomerRepository implements CustomerDao {
    private CustomerDao customerDao;
    public CustomerRepository(){
        customerDao = new CustomerDaoImp();
    }
    @Override
    public CustomerDto getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public Boolean addCustomer(CustomerDto customerDto) {
        return customerDao.addCustomer(customerDto);
    }

    @Override
    public Boolean updateCustomer(CustomerDto customerDto) {
        return customerDao.updateCustomer(customerDto);
    }

    @Override
    public List<CustomerDto> getCustomersByName(String name) {
        return customerDao.getCustomersByName(name);
    }

    @Override
    public List<RentalDto> getCustomerRentalById(int id) {
        return customerDao.getCustomerRentalById(id);
    }

    @Override
    public List<PaymentDto> getCustomerPaymentById(int id) {
        return customerDao.getCustomerPaymentById(id);
    }

    @Override
    public List<CustomerDto> getAllActiveCustomers() {
        return customerDao.getAllActiveCustomers();
    }

    @Override
    public List<CustomerDto> getAllInactiveCustomers() {
        return customerDao.getAllInactiveCustomers();
    }
}
