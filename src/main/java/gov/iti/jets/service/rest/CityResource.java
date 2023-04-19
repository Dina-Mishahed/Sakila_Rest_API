package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.CityRepository;
import gov.iti.jets.service.dto.CityDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


import java.util.List;


@Path("city")
public class CityResource {
    private CityRepository cityRepository = new CityRepository();

    @GET
    @Path("{countryId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public CityDto getCityById(@PathParam("countryId") int id){
        return cityRepository.getCityById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CityDto> getAllCity() {
        return cityRepository.getAllCities();
    }

}
