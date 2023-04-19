package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.FilmRepository;
import gov.iti.jets.service.dto.FilmDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("film")
public class FilmResource {

    private FilmRepository filmRepository = new FilmRepository();

//    public Boolean createFilm(FilmDto film) {
//        return filmRepository.createFilm(film);
//    }


    @GET
    @Path("{filmId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public FilmDto getFilmById(@PathParam("filmId") short id) {
        return filmRepository.getFilmById(id);
    }

//    public Boolean updateFilm(@WebParam(name = "film")FilmDto filmDto) {
//        return filmRepository.updateFilm(filmDto);
//    }
//
//    public void deleteFilm(@WebParam(name = "FilmId")short id) {
//        filmRepository.deleteFilm(id);
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FilmDto> getAllFilms() {
        return filmRepository.getAllFilms();
    }
}
