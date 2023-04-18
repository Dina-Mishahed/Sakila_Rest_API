package gov.iti.jets.service.soap;

import gov.iti.jets.persistence.repository.LanguageRepository;
import gov.iti.jets.service.dto.LanguageDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

import java.util.List;

public class LanguageService {
    private LanguageRepository languageRepository = new LanguageRepository();

    @WebMethod(operationName = "FindLanguageById")
    public LanguageDto getLanguageById(@WebParam(name = "languageId") short id){
        return languageRepository.getLanguageById(id);
    }

    @WebMethod(operationName = "FindAllLanguage")
    public List<LanguageDto> getAllLanguage() {
        return languageRepository.getAllLanguage();
    }
}
