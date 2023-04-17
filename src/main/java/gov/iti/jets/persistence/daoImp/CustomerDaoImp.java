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

public class CustomerDaoImp implements CustomerDao {
    private CustomerMapper customerMapper ;
    private RentalMapper rentalMapper ;
    private PaymentMapper paymentMapper ;


    public CustomerDaoImp(){
        customerMapper = Mappers.getMapper(CustomerMapper.class);
        rentalMapper = Mappers.getMapper(RentalMapper.class);
        paymentMapper = Mappers.getMapper(PaymentMapper.class);
    }
    @Override
    public CustomerDto getCustomerById(int id) {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
            Root<Customer> root = cq.from(Customer.class);
            cq.where(cb.equal(root.get("customerId"), id));
            TypedQuery<Customer> query = entityManager.createQuery(cq);
            CustomerDto actorDto =  customerMapper.toDto(query.getSingleResult());
            return actorDto;
        } catch (NoResultException e) {
            return null;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
            Root<Customer> root = cq.from(Customer.class);
            cq.select(root);

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
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
            Root<Customer> root = cq.from(Customer.class);
            cq.where(cb.equal(root.get("customerId"), id));
            TypedQuery<Customer> query = entityManager.createQuery(cq);
            List<Rental> rentalList = query.getSingleResult().getRentalList();
            List<RentalDto> rentalDtos = rentalList.stream().map((rental -> rentalMapper.toDto(rental))).toList();
            return rentalDtos;
        } catch (NoResultException e) {
            return null;
        }finally{
            entityManager.close();
        }
    }


    @Override
    public List<PaymentDto> getCustomerPaymentById(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
            Root<Customer> root = cq.from(Customer.class);
            cq.where(cb.equal(root.get("customerId"), id));
            TypedQuery<Customer> query = entityManager.createQuery(cq);
            List<Payment> paymentList = query.getSingleResult().getPaymentList();
            List<PaymentDto> paymentDtoList = paymentList.stream().map((payment -> paymentMapper.toDto(payment))).toList();
            return paymentDtoList;
        } catch (NoResultException e) {
            return null;
        }finally{
            entityManager.close();
        }
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
}
