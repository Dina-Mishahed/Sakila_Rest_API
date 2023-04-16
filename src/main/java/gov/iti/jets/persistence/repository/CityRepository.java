package gov.iti.jets.persistence.repository;

import gov.iti.jets.persistence.dao.CityDao;
import gov.iti.jets.persistence.daoImp.CityDaoImp;
import gov.iti.jets.service.dto.CityDto;

import java.util.List;

public class CityRepository implements CityDao {
    private CityDao cityDao;
    public CityRepository(){
        cityDao = new CityDaoImp();
    }
    @Override
    public CityDto getCityById(int id) {
        return cityDao.getCityById(id);
    }

    @Override
    public List<CityDto> getAllCities() {
        return cityDao.getAllCities();
    }
}
