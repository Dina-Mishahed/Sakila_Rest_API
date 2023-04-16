package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.CityDao;
import gov.iti.jets.persistence.entity.City;
import gov.iti.jets.persistence.entity.Country;
import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import gov.iti.jets.service.dto.CityDto;
import gov.iti.jets.service.dto.CountryDto;
import gov.iti.jets.service.mapper.CityMapper;
import gov.iti.jets.service.mapper.CountryMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

public class CityDaoImp implements CityDao {
    private CityMapper cityMapper;

    public CityDaoImp(){
        cityMapper = Mappers.getMapper(CityMapper.class);
    }
    @Override
    public CityDto getCityById(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<City> cq = cb.createQuery(City.class);
            Root<City> root = cq.from(City.class);
            cq.where(cb.equal(root.get("cityId"), id));
            TypedQuery<City> query = entityManager.createQuery(cq);
            CityDto cityDto =  cityMapper.toDto(query.getSingleResult());
            return cityDto;
        } catch (NoResultException e) {
            return null;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public List<CityDto> getAllCities() {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<City> cq = cb.createQuery(City.class);
            Root<City> root = cq.from(City.class);
            cq.select(root);
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
