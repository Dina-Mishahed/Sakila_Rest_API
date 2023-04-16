package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.CityDto;
import gov.iti.jets.service.dto.CountryDto;

import java.util.List;

public interface CountryDao {
    CountryDto getCountryById(int countryId);
    List<CountryDto> getAllCountries();
    List<CityDto> getAllCitiesByCountry(int countryId);
}
