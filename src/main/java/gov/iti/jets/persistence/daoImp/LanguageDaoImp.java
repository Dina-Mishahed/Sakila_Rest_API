package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.LanguageDao;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.service.dto.*;
import gov.iti.jets.service.mapper.CityMapper;
import gov.iti.jets.service.mapper.FilmMapper;
import gov.iti.jets.service.mapper.LanguageMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class LanguageDaoImp extends BaseDAO implements LanguageDao {
    private LanguageMapper languageMapper;
    private Language language;
    private FilmMapper filmMapper;

    public LanguageDaoImp(){
        languageMapper = Mappers.getMapper(LanguageMapper.class);
        filmMapper = Mappers.getMapper(FilmMapper.class);
    }
    @Override
    public LanguageDto getLanguageById(int id) {
        language = getById(id);
        return languageMapper.toDto(language);
    }

    @Override
    public List<LanguageDto> getAllLanguage() {
        List<Language> languageList = getAll(Language.class);
        List<LanguageDto> languageDtos = languageList.stream().map((language -> languageMapper.toDto(language))).toList();
        return languageDtos;
    }

    @Override
    public List<FilmDto> getFilmListByLanguage(int id) {
        language = getById(id);
        List<Film> filmList = language.getFilmList();
        List<FilmDto> filmDtoList = filmList.stream().map((film -> filmMapper.toDto(film))).toList();
        return filmDtoList;
    }

    @Override
    public List<FilmDto> getFilmListByoriginalLanguageId(int id) {
        language = getById(id);
        List<Film> filmList = language.getFilmList1();
        List<FilmDto> filmDtoList = filmList.stream().map((film -> filmMapper.toDto(film))).toList();
        return filmDtoList;
    }
    private Language getById(int id){
        return (Language) get(Language.class,"languageId",id);
    }
}
