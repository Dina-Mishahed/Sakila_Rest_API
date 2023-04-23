package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.FilmRepository;
import gov.iti.jets.service.dto.FilmDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.List;

@Path("films")
public class FilmResource {
    private FilmRepository filmRepository = new FilmRepository();


    @POST
    @Path("addFilm")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean createFilm(FilmDto film) {
        return filmRepository.createFilm(film);
    }

    @GET
    @Path("{filmId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public FilmDto getFilmById(@PathParam("filmId") short id) {
        return filmRepository.getFilmById(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean updateFilm(FilmDto filmDto) {
        return filmRepository.updateFilm(filmDto);
    }

    @DELETE
    @Path("{filmId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteFilm(@PathParam("filmId")short id) {
        filmRepository.deleteFilm(id);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public List<FilmDto> getAllFilms() {
        return filmRepository.getAllFilms();
    }
}
