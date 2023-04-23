package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.LanguageRepository;
import gov.iti.jets.service.dto.LanguageDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Path("languages")
public class LanguageResource {
    private LanguageRepository languageRepository = new LanguageRepository();

    @GET
    @Path("{rentalId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public LanguageDto getLanguageById(@PathParam( "rentalId") short id){
        return languageRepository.getLanguageById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LanguageDto> getAllLanguage() {
        return languageRepository.getAllLanguage();
    }
}
