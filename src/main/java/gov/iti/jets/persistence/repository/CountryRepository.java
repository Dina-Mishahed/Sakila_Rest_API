package gov.iti.jets.persistence.repository;

import gov.iti.jets.persistence.dao.CountryDao;
import gov.iti.jets.persistence.daoImp.CountryDaoImp;
import gov.iti.jets.service.dto.CityDto;
import gov.iti.jets.service.dto.CountryDto;

import java.util.List;

public class CountryRepository implements CountryDao {
    private CountryDao countryDao ;
    public CountryRepository(){
        countryDao = new CountryDaoImp();
    }
    @Override
    public CountryDto getCountryById(int countryId) {
        return countryDao.getCountryById(countryId);
    }

    @Override
    public List<CountryDto> getAllCountries() {
        return countryDao.getAllCountries();
    }

    @Override
    public List<CityDto> getAllCitiesByCountry(int countryId) {
        return countryDao.getAllCitiesByCountry(countryId);
    }
}
