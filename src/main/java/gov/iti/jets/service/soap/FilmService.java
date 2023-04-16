package gov.iti.jets.service.soap;

import gov.iti.jets.persistence.repository.ActorRepository;
import gov.iti.jets.persistence.repository.FilmRepository;
import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.service.dto.FilmDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

import java.util.Date;
import java.util.List;

public class FilmService {


    private FilmRepository filmRepository = new FilmRepository();
    @WebMethod(operationName = "AddNewFilm")
    public Boolean createFilm(FilmDto film) {
        return filmRepository.createFilm(film);
    }
    @WebMethod(operationName = "FindFilmById")
    public FilmDto getFilmById(@WebParam(name = "filmId")short id) {
        return filmRepository.getFilmById(id);
    }
    @WebMethod(operationName = "EditFilmData")
    public Boolean updateFilm(@WebParam(name = "film")FilmDto filmDto) {
        return filmRepository.updateFilm(filmDto);
    }
    @WebMethod(operationName = "DeleteFilm")
    public void deleteFilm(@WebParam(name = "FilmId")short id) {
        filmRepository.deleteFilm(id);
    }
    @WebMethod(operationName = "FindAllFilms")
    public List<FilmDto> getAllFilms() {
        return filmRepository.getAllFilms();
    }
}
