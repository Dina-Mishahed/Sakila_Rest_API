package gov.iti.jets.persistence.dao;

import java.util.List;

import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.service.dto.FilmDto;

public interface FilmDao {
    Boolean createFilm(FilmDto film);
    FilmDto getFilmById(int id);
    Boolean updateFilm(FilmDto film);
    Boolean deleteFilm(int id);
    List<FilmDto> getAllFilms();

}
