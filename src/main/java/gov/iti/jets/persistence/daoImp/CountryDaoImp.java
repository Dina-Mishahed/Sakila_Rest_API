package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.CountryDao;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.service.dto.CityDto;
import gov.iti.jets.service.dto.CountryDto;
import gov.iti.jets.service.mapper.CityMapper;
import gov.iti.jets.service.mapper.CountryMapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

public class CountryDaoImp extends BaseDAO implements CountryDao {
    private CountryMapper countryMapper;
    private CityMapper cityMapper;

    public CountryDaoImp(){
        countryMapper = Mappers.getMapper(CountryMapper.class);
        cityMapper = Mappers.getMapper(CityMapper.class);
    }
    @Override
    public CountryDto getCountryById(int id) {
        Country country = (Country) get(Country.class,"countryId",id);
        return countryMapper.toDto(country);
    }

    @Override
    public List<CountryDto> getAllCountries() {
        List<Country> countryList = getAll(Country.class);
        return countryList.stream().map((country -> countryMapper.toDto(country))).toList();
    }
    @Override
    public List<CityDto> getAllCitiesByCountry(int countryId) {
        List<City> cities = getListByJoin(City.class,Country.class,"countryId",countryId);
        return cities.stream().map((city -> cityMapper.toDto(city))).toList();
    }
}
