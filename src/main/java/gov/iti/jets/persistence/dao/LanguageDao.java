package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.FilmDto;
import gov.iti.jets.service.dto.LanguageDto;
import gov.iti.jets.service.dto.RentalDto;
import gov.iti.jets.service.dto.StaffDto;

import java.util.List;

public interface LanguageDao {
    LanguageDto getLanguageById(int id);
    List<LanguageDto> getAllLanguage();
    List<FilmDto> getFilmListByLanguage(int id);
    List<FilmDto> getFilmListByoriginalLanguageId(int id);

}
