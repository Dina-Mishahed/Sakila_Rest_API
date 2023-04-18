package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.CityDao;
import gov.iti.jets.persistence.entity.City;
import gov.iti.jets.service.dto.CityDto;
import gov.iti.jets.service.mapper.CityMapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

public class CityDaoImp extends BaseDAO implements CityDao {
    private CityMapper cityMapper;

    public CityDaoImp(){
        cityMapper = Mappers.getMapper(CityMapper.class);
    }
    @Override
    public CityDto getCityById(int id) {
        City city = (City) get(City.class,"cityId",id);
        return cityMapper.toDto(city);
    }
    @Override
    public List<CityDto> getAllCities() {
        List<City> cities = getAll(City.class);
        List<CityDto> cityDtoList = cities.stream().map((city -> cityMapper.toDto(city))).toList();
        return cityDtoList;
    }
}
