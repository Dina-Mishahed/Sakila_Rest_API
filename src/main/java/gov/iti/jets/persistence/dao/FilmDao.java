package gov.iti.jets.persistence.dao;

import java.util.List;

import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.entity.FilmActor;
import gov.iti.jets.persistence.entity.FilmCategory;
import gov.iti.jets.persistence.entity.Inventory;
import gov.iti.jets.service.dto.FilmActorDto;
import gov.iti.jets.service.dto.FilmCategoryDto;
import gov.iti.jets.service.dto.FilmDto;
import gov.iti.jets.service.dto.InventoryDto;

public interface FilmDao {
    Boolean createFilm(FilmDto film);
    FilmDto getFilmById(int id);
    Boolean updateFilm(FilmDto film);
    Boolean deleteFilm(int id);
    List<FilmDto> getAllFilms();
    List<InventoryDto> inventoryList();
    List<FilmActorDto> filmActorList();
    List<FilmCategoryDto> filmCategoryList();

}
