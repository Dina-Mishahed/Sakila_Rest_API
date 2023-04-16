package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.CountryDao;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.service.dto.CityDto;
import gov.iti.jets.service.dto.CountryDto;
import gov.iti.jets.service.mapper.CityMapper;
import gov.iti.jets.service.mapper.CountryMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

public class CountryDaoImp implements CountryDao {
    private CountryMapper countryMapper;
    private CityMapper cityMapper;

    public CountryDaoImp(){
        countryMapper = Mappers.getMapper(CountryMapper.class);
        cityMapper = Mappers.getMapper(CityMapper.class);
    }
    @Override
    public CountryDto getCountryById(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Country> cq = cb.createQuery(Country.class);
            Root<Country> root = cq.from(Country.class);
            cq.where(cb.equal(root.get("countryId"), id));
            TypedQuery<Country> query = entityManager.createQuery(cq);
            CountryDto countryDto =  countryMapper.toDto(query.getSingleResult());
            return countryDto;
        } catch (NoResultException e) {
            return null;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public List<CountryDto> getAllCountries() {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Country> cq = cb.createQuery(Country.class);
            Root<Country> root = cq.from(Country.class);
            cq.select(root);

            TypedQuery<Country> query = entityManager.createQuery(cq);
            List<Country> countries = query.getResultList();
            List<CountryDto> countryDtos = new ArrayList<>();
            for (Country country : countries) {
                CountryDto countryDto = countryMapper.toDto(country);
                countryDtos.add(countryDto);
            }
            return countryDtos;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }
    @Override
    public List<CityDto> getAllCitiesByCountry(int countryId) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<City> cq = cb.createQuery(City.class);
            Root<City> root = cq.from(City.class);
            Join<City, Country> countryJoin = root.join("countryId");
            Predicate countryPredicate = cb.equal(countryJoin.get("countryId"), countryId);
            cq.select(root).where(countryPredicate);
            TypedQuery<City> query = entityManager.createQuery(cq);

            List<City> cities = query.getResultList();
            List<CityDto> cityDtos = new ArrayList<>();
            for (City city : cities) {
                CityDto cityDto = cityMapper.toDto(city);
                cityDtos.add(cityDto);
            }
            return cityDtos;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }
}
