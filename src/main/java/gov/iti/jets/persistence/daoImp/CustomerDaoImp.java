package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.CustomerDao;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import gov.iti.jets.service.dto.*;
import gov.iti.jets.service.mapper.CustomerMapper;
import gov.iti.jets.service.mapper.PaymentMapper;
import gov.iti.jets.service.mapper.RentalMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImp extends BaseDAO implements CustomerDao {
    private CustomerMapper customerMapper ;
    private RentalMapper rentalMapper ;
    private PaymentMapper paymentMapper ;
    private Customer customer;


    public CustomerDaoImp(){
        customerMapper = Mappers.getMapper(CustomerMapper.class);
        rentalMapper = Mappers.getMapper(RentalMapper.class);
        paymentMapper = Mappers.getMapper(PaymentMapper.class);
    }
    @Override
    public CustomerDto getCustomerById(int id) {
        customer = getById(id);
        return customerMapper.toDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customerList = getAll(Customer.class);
        return customerList.stream().map((customer -> customerMapper.toDto(customer))).toList();
    }

    @Override
    public Boolean addCustomer(CustomerDto customerDto) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            Customer customer = customerMapper.toEntity(customerDto);
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public Boolean updateCustomer(CustomerDto customerDto) {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            Customer customer = customerMapper.toEntity(customerDto);
            entityManager.getTransaction().begin();
            entityManager.merge(customer);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public List<CustomerDto> getCustomersByName(String name) {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
            Root<Customer> root = cq.from(Customer.class);
            cq.select(root);
            if (name != null && !name.isEmpty()) {
                Predicate predicate = cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
                cq.where(predicate);
            }
            TypedQuery<Customer> query = entityManager.createQuery(cq);
            List<Customer> customers = query.getResultList();
            List<CustomerDto> customerDtos = new ArrayList<>();
            for (Customer customer : customers) {
                CustomerDto customerDto = customerMapper.toDto(customer);
                customerDtos.add(customerDto);
            }
            return customerDtos;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public List<RentalDto> getCustomerRentalById(int id) {
        customer = getById(id);
        List<Rental> rentalList = customer.getRentalList();
        List<RentalDto> rentalDtos = rentalList.stream().map((rental -> rentalMapper.toDto(rental))).toList();
        return rentalDtos;
    }


    @Override
    public List<PaymentDto> getCustomerPaymentById(int id) {
        customer = getById(id);
        List<Payment> paymentList = customer.getPaymentList();
        List<PaymentDto> paymentDtoList = paymentList.stream().map((payment -> paymentMapper.toDto(payment))).toList();
        return paymentDtoList;
    }

    @Override
    public List<CustomerDto> getAllActiveCustomers() {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
            Root<Customer> root = cq.from(Customer.class);
            cq.select(root);

            cq.where(cb.equal(root.get("active"), true));
            TypedQuery<Customer> query = entityManager.createQuery(cq);
            List<Customer> customers = query.getResultList();
            List<CustomerDto> customerDtos = new ArrayList<>();
            for (Customer customer : customers) {
                CustomerDto customerDto = customerMapper.toDto(customer);
                customerDtos.add(customerDto);
            }
            return customerDtos;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public List<CustomerDto> getAllInactiveCustomers() {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
            Root<Customer> root = cq.from(Customer.class);
            cq.select(root);

            cq.where(cb.equal(root.get("active"), false));
            TypedQuery<Customer> query = entityManager.createQuery(cq);
            List<Customer> customers = query.getResultList();
            List<CustomerDto> customerDtos = new ArrayList<>();
            for (Customer customer : customers) {
                CustomerDto customerDto = customerMapper.toDto(customer);
                customerDtos.add(customerDto);
            }
            return customerDtos;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }

    private Customer getById(int id){
        return (Customer) get(Customer.class,"customerId",id);
    }

}
