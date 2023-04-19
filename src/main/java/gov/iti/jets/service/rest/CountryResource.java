package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.CountryRepository;
import gov.iti.jets.service.dto.CityDto;
import gov.iti.jets.service.dto.CountryDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("country")
public class CountryResource {
    private CountryRepository countryRepository = new CountryRepository();


    @GET
    @Path("{countryId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public CountryDto getCountryById(@PathParam("countryId") int countryId) {
        return countryRepository.getCountryById(countryId);
    }

//    @GET
//    @Path("{countryId: [0-9]+}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<CityDto> getAllCitiesByCountry(@Path("countryId") int countryId) {
//        return countryRepository.getAllCitiesByCountry(countryId);
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CountryDto> getAllCountry() {
        return countryRepository.getAllCountries();
    }
}
