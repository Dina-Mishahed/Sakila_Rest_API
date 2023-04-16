package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.CityDto;

import java.util.List;

public interface CityDao {
     CityDto getCityById(int id);
     List<CityDto> getAllCities();
}
