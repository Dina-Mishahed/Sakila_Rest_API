package gov.iti.jets.service.soap;

import gov.iti.jets.persistence.repository.CountryRepository;
import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.service.dto.CityDto;
import gov.iti.jets.service.dto.CountryDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class CountryService {
    private CountryRepository countryRepository = new CountryRepository();
    @WebMethod(operationName = "FindCountryById")
    public CountryDto getCountryById(@WebParam(name = "countryId")int countryId) {
        return countryRepository.getCountryById(countryId);
    }
    @WebMethod(operationName = "FindAllCitiesByCountry")
    public List<CityDto> getAllCitiesByCountry(@WebParam(name = "countryId")int countryId) {
        return countryRepository.getAllCitiesByCountry(countryId);
    }
    @WebMethod(operationName = "FindAllCountry")
    public List<CountryDto> getAllCountry() {
        return countryRepository.getAllCountries();
    }
}
