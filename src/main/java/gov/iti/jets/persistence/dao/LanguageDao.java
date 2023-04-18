package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.LanguageDto;
import gov.iti.jets.service.dto.RentalDto;

import java.util.List;

public interface LanguageDao {
    LanguageDto getLanguageById(int id);
    List<LanguageDto> getAllLanguage();
}
