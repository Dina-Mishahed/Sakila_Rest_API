package gov.iti.jets.persistence.repository;

import java.util.List;

import gov.iti.jets.persistence.dao.FilmDao;
import gov.iti.jets.persistence.daoImp.FilmDaoImp;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.service.dto.FilmActorDto;
import gov.iti.jets.service.dto.FilmCategoryDto;
import gov.iti.jets.service.dto.FilmDto;
import gov.iti.jets.service.dto.InventoryDto;

public class FilmRepository implements FilmDao {
    private FilmDaoImp filmDaoImp;
    public FilmRepository(){
        filmDaoImp = new FilmDaoImp();
    }
    @Override
    public Boolean createFilm(FilmDto film) {
        return filmDaoImp.createFilm(film);
    }

    @Override
    public FilmDto getFilmById(int id) {
        return filmDaoImp.getFilmById(id);
    }

    @Override
    public Boolean updateFilm(FilmDto filmDto) {
        return filmDaoImp.updateFilm(filmDto);
    }

    @Override
    public Boolean deleteFilm(int id) {
        return filmDaoImp.deleteFilm(id);
    }

    @Override
    public List<FilmDto> getAllFilms() {
        return filmDaoImp.getAllFilms();
    }

    @Override
    public List<InventoryDto> getInventoryListByFilm(int id) {
        return filmDaoImp.getInventoryListByFilm(id);
    }

    @Override
    public List<FilmActorDto> getfilmActorList(int id) {
        return filmDaoImp.getfilmActorList(id);
    }

    @Override
    public List<FilmCategoryDto> getfilmCategoryList(int id) {
        return filmDaoImp.getfilmCategoryList(id);
    }
}
