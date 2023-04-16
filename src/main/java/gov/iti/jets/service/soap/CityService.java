package gov.iti.jets.service.soap;

import gov.iti.jets.persistence.repository.CityRepository;
import gov.iti.jets.persistence.repository.CountryRepository;
import gov.iti.jets.service.dto.CityDto;
import gov.iti.jets.service.dto.CountryDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class CityService {
    private CityRepository cityRepository = new CityRepository();

    @WebMethod(operationName = "FindCityById")
    public CityDto getCityById(@WebParam(name = "cityId") int id){
        return cityRepository.getCityById(id);
    }

    @WebMethod(operationName = "FindAllCity")
    public List<CityDto> getAllCity() {
        return cityRepository.getAllCities();
    }

}
