package gov.iti.jets.persistence.repository;

import gov.iti.jets.persistence.dao.LanguageDao;
import gov.iti.jets.persistence.daoImp.LanguageDaoImp;
import gov.iti.jets.service.dto.FilmDto;
import gov.iti.jets.service.dto.LanguageDto;

import java.util.List;

public class LanguageRepository implements LanguageDao {
    private LanguageDao languageDao;
    public LanguageRepository() {
        languageDao = new LanguageDaoImp();
    }

    @Override
    public LanguageDto getLanguageById(int id) {
        return languageDao.getLanguageById(id);
    }

    @Override
    public List<LanguageDto> getAllLanguage() {
        return languageDao.getAllLanguage();
    }

    @Override
    public List<FilmDto> getFilmListByLanguage(int id) {
        return languageDao.getFilmListByLanguage(id);
    }

    @Override
    public List<FilmDto> getFilmListByoriginalLanguageId(int id) {
        return null;
    }
}
