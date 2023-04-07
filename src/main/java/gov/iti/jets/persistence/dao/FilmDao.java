package gov.iti.jets.persistence.dao;

import java.util.List;

import gov.iti.jets.persistence.entity.Film;

public interface FilmDao {
    Film createFilm(Film film);
    Film getFilmById(int id);
    Film updateFilm(Film film);
    void deleteFilm(int id);
    List<Film> getAllFilms();
}
